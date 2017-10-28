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
	private static final String PROMPT_TEMPLATE="What's your choice %s (%s)? ";
	
	/**
	 * &quot;Sorry, '%s' is not a valid choice!&quot;
	 */
	private static final String BAD_INPUT_MSG_TEMPLATE="Sorry, '%s' is not a valid choice!";
	
	/**
	 * &quot;The cell at (%d,%d) is not empty.!&quot;
	 */
	private static final String NOTEMPTY_CELL_MSG_TEMPLATE="The cell at (%d,%d) is not empty or out of range.";
	
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

	/**
	 * Writes a line to this.writer and then flushes
	 * @param line
	 */
	private void println(String line) {
		writer.println(line);
		writer.flush();		
	}
	
	/**
	 * Writes a line to this.writer and then flushes
	 * @param line
	 */
	private void print(String line) {
		writer.println(line);
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
			
			print(String.format(PROMPT_TEMPLATE, player.getName(), player.getGlyph()));			
			line = reader.readLine();
					
			if(	(line != null) &&
				(line.matches("^\\s*\\d{1,2}\\s*\\,\\s*\\d{1,2}\\s*$")) 
			)
			{
					
				String[]  coordinates = line.trim().split("\\s*,\\s*");
				int row = Integer.parseInt(coordinates[0]);
				int col = Integer.parseInt(coordinates[1]);
				
				
				if(!(
					gameState.isValidCoordinate(row, col) == true && 
					gameState.getPlayer(row, col) == null
					)
				) {
					
					println(String.format(NOTEMPTY_CELL_MSG_TEMPLATE, row, col));
					continue;
				}
				
				choice = new Choice(row, col, player);
			} else {
				
				println(BAD_INPUT_MSG_TEMPLATE);
			}
			
		}
		
		return choice;
	}

}
