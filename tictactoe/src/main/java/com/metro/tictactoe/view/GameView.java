package com.metro.tictactoe.view;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;
import com.metro.tictactoe.input.ChoiceInput;

/**
 * <p>This class contains the game's main loop.</p>
 * @author rsolano
 *
 */
public abstract class GameView {

	/**
	 * This controller manages game logic.
	 */
	GameController controller;
	
	/**
	 * <p>Each element in this array represent an input stream through which player provide their choices.</p>
	 * <p>There is one <code>com.metro.tictactoe.input.ChoiceInput</code> instance per player.</p>
	 */
	ChoiceInput[] inputs;
	
	/**
	 * <p>This constructor initializes fields whose names match parameters.</p>
	 * @param inputs There is one <code>com.metro.tictactoe.input.ChoiceInput</code> instance per player
	 * @param controller This controller manages game logic.
	 * @throws GameException
	 */
	public GameView(
		ChoiceInput[] inputs, 
		GameController controller
	) throws GameException {
	
		this.inputs = inputs;
		this.controller = controller;
	}
	
	/**
	 * <p>It is just a proxy for <code>com.metro.tictactoe.controller.GameController.gameOver()</code>.</p>
	 * <p>Developers can override this method in order to customize termination logic without subclassing or modifying the game controller.</p>
	 * @return Returns <code>false</code> when game is over. 
	 */
	public boolean gameOver() {		
		return controller.gameOver();
	}
	
	/**
	 * <p>Updates the UI view that depicts game's state.</p>
	 */
	public abstract void  displayState();

	/**
	 * Grabs input from players.
	 */
	public abstract void  getInput();
	
	/**
	 * <p>Starts the game logic</p>
	 * <p>The internal loop runs in the curren thread</p>
	 */
	public void start() {
		while(! gameOver()) {
			getInput();
			displayState();
		}
	}
}
