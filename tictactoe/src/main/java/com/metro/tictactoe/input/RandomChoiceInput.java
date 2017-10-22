package com.metro.tictactoe.input;

import java.io.IOException;
import java.io.PrintWriter;

import com.metro.tictactoe.GameState;
import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;

/**
 * <p>This class represents a stream of randomly generated choices.</p>
 * @author rsolano
 *
 */
public class RandomChoiceInput extends ChoiceInput {

	/**
	 * Current game's state.
	 */
	GameState state;
	
	
	/**
	 * &quot;What's your choice %s ?&quot;
	 */
	private static final String PROMPT_TEMPLATE="%s (aka 'the computer') made this random choice : ";
	
	
	/**
	 * Text writer used for feedback. 
	 */
	private PrintWriter printer;
	
	/**
	 * 
	 * @param player The player who makes the choices (usually the computer).
	 * @param state Current game's state.
	 * @param printer Text writer used for feedback.
	 */	
	public RandomChoiceInput(Player player, GameState state, PrintWriter printer) {
		
		super(player);
		this.state = state;
		this.printer = printer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Choice read() throws IOException {
		
		int row = (int)(Math.random() * 100);
		int col = (int)(Math.random() * 100);
		
		printer.println(String.format(PROMPT_TEMPLATE, player.getName()));
		printer.flush();
		
		while(state.getPlayer(row, col) == null) {
			
			row = (int)(Math.random() * 100);
			col = (int)(Math.random() * 100);		
		}
		
		Choice choice = new Choice(row, col, player);
		return choice;		
	}

}
