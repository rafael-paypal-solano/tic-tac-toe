package com.metro.tictactoe.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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
	 * @param reader Input reader through which the player sends his choices.
	 * @param writer Text writer used for feedback.
	 */
	public ConsoleChoiceInput(Player player, BufferedReader reader, PrintWriter writer) {
		
		super(player);
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Choice read() throws IOException {
		
		
		Choice choice = null;
		String line;
		
		while(choice == null) {
			
			writer.println(String.format(PROMPT_TEMPLATE, player.getName()));
			writer.flush();
			line = reader.readLine();
					
			if(	(line != null) &&
				(line.matches("^\\s*\\d{1,2}\\s*\\,\\s*\\d{1,2}\\s*$")) 
			)
			{
					
				String[]  coordinates = line.trim().split("\\s*,\\s*");
				choice = new Choice(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), player);
				
			} else if (line == null){
				
				break;
				
			} else {
				
				writer.println(BAD_INPUT_MSG_TEMPLATE);
			}
			
		}
		
		return choice;
	}

}
