package com.metro.tictactoe.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.GameState;
import com.metro.tictactoe.model.Canvas;
import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;

/**
 * <p>This class implements state management and game logic.</p>
 * @author rsolano
 *
 */
@SuppressWarnings("unused")
public class GameController {

	/**
	 * <code>Min grid size.</code>
	 */
	public static final int MIN_SIZE=3;
	
	/**
	 * <code>Max grid size</code>
	 */
	public static final int MAX_SIZE=10;
	
	
	/**
	 * <p>TicTacToe canvas.</p>
	 */
	Canvas canvas;
	
	/**
	 * Set to <code>true</code> if game finishes with a winning selection.
	 */	
	boolean winner;
	
	/**
	 * Array of helper threads used by GameController to find straight winning lines.
	 */
	StraightLineScanner[] straightLineScanners;
	
	
	public GameController(int  size) throws GameException {
		
		if(size < MIN_SIZE || size > MAX_SIZE)
			throw new GameException(
				String.format(
					"Canvas size must be an integer value between %d and %d",
					MIN_SIZE,
					MAX_SIZE
				)
			);
		
		straightLineScanners = new StraightLineScanner[size];
		
		for(int i = 0; i < size; i++)
			straightLineScanners[i] = new StraightLineScanner();
		canvas = new Canvas(size);
	}

	/**
	 * <p>Updates the game state. Changes made through this method are affect <code>getState()</code>'s return value.</p>
	 * @param choice
	 * @return <code>true</code> if game state changed according to data provided by <code>choice</code>.
	 */
	public boolean updateState(Choice choice) {
		
		return canvas.setPlayer(choice.getRow(), choice.getCol(), choice.getPlayer());
	}
	/**
	 * 
	 * @return  current game's state.
	 */
	public GameState getState() {		
		return canvas;
	}
	
	/**
	 * @return Returns <code>false</code> when game is over. 
	 * @throws GameException 
	 */	
	public boolean gameOver() throws GameException {
		int size = getState().getSize();
		
		try {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			ThreadPoolExecutor executor = new ThreadPoolExecutor(size, size, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(size));
			
			//
			// Use parallel processing to find winning straight lines.
			//
			
			for(int i = 0; i < canvas.getSize(); i++) {
				
				straightLineScanners[i].reset(canvas, i+1);
				executor.execute(straightLineScanners[i]);
			}

			
			executor.shutdown();
			try {
			    if (!executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
			    	executor.shutdownNow();
			    } 
			} catch (InterruptedException e) {
				executor.shutdownNow();
			} 
	        
			for(int i = 0; i < canvas.getSize(); i++) {
				
				if(straightLineScanners[i].isComplete()) {
					
					winner = true;
					return true;
				}
			}
			
			if(size * size == canvas.getCount()) {				
				return true;
			}
				
		}  catch(RuntimeException e) {
			throw new GameException(e);
		} 
		
		
		return false;
	}

	/**
	 * 
	 * @return <code>true</code> if game finishes with a winning selection.
	 */
	public boolean isWinner() {
		return winner;
	}
	
	
}
