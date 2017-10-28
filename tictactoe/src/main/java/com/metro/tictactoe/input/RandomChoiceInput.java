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
	private static final String PROMPT_TEMPLATE="%s (aka 'the computer') made this random choice : (%d, %d) ";
	
	
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
		int row = 0;
		int col = 0;
		
		while(true){
			
			row = (int)(Math.random() * 10);
			col = (int)(Math.random() * 10);
			
			if(!gameState.isValidCoordinate(row, col))
				continue;
				
			if(gameState.getPlayer(row, col) == null)
				break;
		}
		
		writer.println(String.format(PROMPT_TEMPLATE, player.getName(), row, col));
		writer.flush();
		
		Choice choice = new Choice(row, col, player);
		return choice;		
	}

}
