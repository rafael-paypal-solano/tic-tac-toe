package com.metro.tictactoe.controller;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.GameState;
import com.metro.tictactoe.model.Canvas;

/**
 * <p>This class implements state management and game logic.</p>
 * @author rsolano
 *
 */
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
	 * 
	 * @param size
	 * @throws GameException 
	 */
	public GameController(int  size) throws GameException {
		
		if(size < MIN_SIZE || size > MAX_SIZE)
			throw new GameException(
				String.format(
					"Canvas size must be an integer value between %d and %d",
					MIN_SIZE,
					MAX_SIZE
				)
			);
		
		canvas = new Canvas(size);
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
	 */	
	public boolean gameOver() {
		return false;
	}
}
