package com.metro.tictactoe.controller;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.GameState;
import com.metro.tictactoe.model.Canvas;
import com.metro.tictactoe.model.Choice;

/**
 * <p>This class implements state management and game logic.</p>
 * @author rsolano
 *
 */
public class GameController {

	/**
	 * <code>3</code>
	 */
	public static final int MIN_SIZE=3;
	
	/**
	 * <code>10</code>
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
	
}
