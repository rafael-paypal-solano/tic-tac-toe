package com.metro.tictactoe.view;

import java.io.IOException;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;
import com.metro.tictactoe.input.ChoiceInput;
import com.metro.tictactoe.model.Choice;

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
	 * Choices collected by <code>getInput()</code> method.
	 */
	Choice[] choices;
	
	/**
	 * Current player # [0...choice.length()] 
	 */
	int current;
	
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
		this.choices = new Choice[inputs.length];
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
	 * <p>Updates the UI view that shows game's state.</p>
	 * <p>This method is abstract because we didn't want to prescribe a particular rendering interface.</p>
	 */
	public abstract void  displayState();

	/**
	 * Collects input from players.
	 * @return The choice made by the last user who interacted with the game.. Each call may return a different value.
	 * @throws GameException 
	 * @throws IOException 
	 */
	public Choice  getInput() throws GameException, IOException {
		current = (current == choices.length ? 0  : current + 1);
		
		Choice choice = inputs[current].read();
		return choice;
	}
	
	/**
	 * <p>Starts the game logic</p>
	 * <p>The internal loop runs in the curren thread</p>
	 * @throws GameException 
	 */
	public void start() throws GameException {
		try {
			
			while(! gameOver()) {
				Choice choice = getInput();
				
				displayState();
			}
		} catch(IOException e) {
			
			throw new GameException(e);
		}
	}
}
