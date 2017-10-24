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
	 * &quot;What's your choice %s ?&quot;
	 */
	private static final String PROMPT_TEMPLATE="%s (aka 'the computer') made this random choice : ";
	
	
	/**
	 * Text writer used for feedback. 
	 */
	private PrintWriter writer;
	
	/**
	 * 
	 * @param player The player who makes the choices.
	 * @param gameState Current game's state.
	 * @param writer Text writer used for feedback.
	 */
	public RandomChoiceInput(Player player, GameState gameState, PrintWriter writer) {
		
		super(player, gameState);
		this.writer = writer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Choice read() throws IOException {
		
		int row = (int)(Math.random() * 100);
		int col = (int)(Math.random() * 100);
		
		writer.println(String.format(PROMPT_TEMPLATE, player.getName()));
		writer.flush();
		
		while(gameState.getPlayer(row, col) == null) {
			
			row = (int)(Math.random() * 100);
			col = (int)(Math.random() * 100);		
		}
		
		Choice choice = new Choice(row, col, player);
		return choice;		
	}

}
