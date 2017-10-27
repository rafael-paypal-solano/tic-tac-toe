package com.metro.tictactoe.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.metro.tictactoe.GameState;
import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;

/**
 * <p>This class represents the choice stream connected to standard input.</p>
 * @author rsolano
 *
 */
public class ConsoleChoiceInput extends ChoiceInput {
	
	/**
	 * &quot;What's your choice %s ?&quot;
	 */
	private static final String PROMPT_TEMPLATE="What's your choice %s ? ";
	
	/**
	 * &quot;Sorry, '%s' is not a valid choice!&quot;
	 */
	private static final String BAD_INPUT_MSG_TEMPLATE="Sorry, '%s' is not a valid choice!";
	
	/**
	 * &quot;The cell at (%d,%d) is not empty.!&quot;
	 */
	private static final String NOTEMPTY_CELL_MSG_TEMPLATE="The cell at (%d,%d) is not empty.";
	
	/**
	 * <code>java.io.BufferedReader</code> instance pointing to standard input.
	 */
	BufferedReader reader;
	
	/**
	 * Text writer used for feedback.
	 */
	PrintWriter writer;
	
	/**
	 * 
	 * @param player The player who makes the choices.
	 * @param gameState Current game's state.
	 * @param reader Input reader through which the player sends his choices.
	 * @param writer Text writer used for feedback.
	 */
	public ConsoleChoiceInput(Player player, GameState gameState, BufferedReader reader, PrintWriter writer) {
		
		super(player, gameState);
		this.reader = reader;
		this.writer = writer;
	}

	private void println(String line) {
		writer.println(String.format(PROMPT_TEMPLATE, player.getName()));
		writer.flush();		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Choice read() throws IOException {
		
		
		Choice choice = null;
		String line = String.valueOf(' ');
		
		while(choice == null && line != null) {
			
			println(String.format(PROMPT_TEMPLATE, player.getName()));			
			line = reader.readLine();
					
			if(	(line != null) &&
				(line.matches("^\\s*\\d{1,2}\\s*\\,\\s*\\d{1,2}\\s*$")) 
			)
			{
					
				String[]  coordinates = line.trim().split("\\s*,\\s*");
				choice = new Choice(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), player);
				
				int row = choice.getRow();
				int col = choice.getCol();
				
				if(
					gameState.getPlayer(row, col) == null &&
					gameState.isValidCoordinate(row, col)
				) {
					
					println(String.format(NOTEMPTY_CELL_MSG_TEMPLATE, choice.getRow(), choice.getCol()));
					
				}
			} else {
				
				println(BAD_INPUT_MSG_TEMPLATE);
			}
			
		}
		
		return choice;
	}

}
