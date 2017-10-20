package com.metro.tictactoe.input;

import java.io.BufferedReader;
import java.io.IOException;

import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;

/**
 * <p>This class represents the stream received through standard input.</p>
 * @author rsolano
 *
 */
public class ConsoleChoiceInput extends ChoiceInput {
	
	/**
	 * &quot;What's your choice %s ?&quot;
	 */
	private static final String PROMPT_TEMPLATE="What's your choice %s ? ";
	BufferedReader reader;
	
	/**
	 * 
	 * @param player The player who makes the choices.
	 * @param reader Input reader through which the player sends his choices.
	 */
	public ConsoleChoiceInput(Player player, BufferedReader reader) {
		super(player);
		this.reader = reader;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Choice read() throws IOException {
		
		
		Choice choice = null;
		String line;
		
		while(true) {
			
			System.out.println(String.format(PROMPT_TEMPLATE, player.getName()));
			line = reader.readLine();
					
			if(line != null) {
				
				if((line = line.trim()).matches("\\d{1,2}\\s*\\,\\s*\\d{1,2}")) {
					
					String[]  coordinates = line.split("\\,");
					choice = new Choice(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]), player);
					break;
					
				} else
					continue;
			}
			
			break;
			
		}
		
		return choice;
	}

}
