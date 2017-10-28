package com.metro.tictactoe.view;


import java.io.PrintWriter;
import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;
import com.metro.tictactoe.input.ChoiceInput;
import com.metro.tictactoe.model.Choice;

/**
 *  <p>This game view displays the game's state into print writer .</p>
 * @author rsolano
 *
 * System.lineSeparator().length()
 */
public class ConsoleView extends GameView{

	/**
	 * Tic tac toe grid.
	 */
	TicTacToeGrid grid;

	/**
	 * Print writer through which we send current game's state.
	 */
	PrintWriter writer;
	
	
	/**
	 * 
	 * @param inputs 
	 * @param controller Controller that managesstate and game logic
	 * @param writer Print writer through which we send current game's state.
	 * @throws GameException
	 */
	public ConsoleView(ChoiceInput[] inputs, GameController controller, PrintWriter writer) throws GameException {
		
		super(inputs, controller);
		grid = new TicTacToeGrid(controller.getState().getSize());
		this.writer = writer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void displayState(Choice choice) {
		
		if(choice != null) {
			grid.set(choice.getRow(), choice.getCol(), choice.getPlayer().getGlyph());
		}
		
		writer.println(grid);
		writer.flush();
	}

	/**
	 * {@inheritDoc}
	 */	
	@Override
	protected void notifyWinner(Choice choice) {
		writer.println(String.format("We have a winner !!! %s (%s)", choice.getPlayer().getName(), choice.getPlayer().getGlyph()));
		writer.flush();
	}

	@Override
	protected void notifyTied(Choice choice) {
		writer.println("Tied up game. ):");
		writer.flush();
		
	}
	

	
}
