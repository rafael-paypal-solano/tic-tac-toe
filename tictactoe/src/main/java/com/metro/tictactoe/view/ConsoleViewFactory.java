package com.metro.tictactoe.view;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;
import com.metro.tictactoe.input.ChoiceInput;
import com.metro.tictactoe.input.ConsoleChoiceInput;
import com.metro.tictactoe.input.RandomChoiceInput;
import com.metro.tictactoe.model.Player;

/**
 * <p>Factory class containing game creation logic.</p>
 * @author rsolano
 *
 */
public class ConsoleViewFactory {
	
	/**
	 * <code>GameException.code</code> is set to <code>MISSING_PROPERTY_ERROR_CODE</code> when a required property is not present in the configuration file.
	 */
	public static final int MISSING_PROPERTY_ERROR_CODE = 1; //Covered
	
	/**
	 * <code>GameException.code</code> is set to <code>SIZE_IS_NOT_INTEGER_ERROR_CODE</code> when the size property is not an integer.
	 */	
	public static final int SIZE_IS_NOT_INTEGER_ERROR_CODE = MISSING_PROPERTY_ERROR_CODE + 1; //Covered
	
	/**
	 * <code>GameException.code</code> is set to <code>CANT_READ_INPUT_ERROR_CODE</code> when the it's not possible to read the config file..
	 */	
	public static final int CANT_READ_INPUT_ERROR_CODE = SIZE_IS_NOT_INTEGER_ERROR_CODE + 1;
	
	/**
	 * <code>GameException.code</code> is set to <code>FILE_NOT_FOUND_ERROR_CODE</code> when the specified config file doesn't exist.
	 */	
	public static final int FILE_NOT_FOUND_ERROR_CODE = CANT_READ_INPUT_ERROR_CODE + 1; //Covered
	
	/**
	 * <code>GameException.code</code> is set to <code>BAD_GLYPH_ERROR_CODE</code> when the supplied glyph is not a single-character string.
	 */	
	public static final int BAD_GLYPH_ERROR_CODE = FILE_NOT_FOUND_ERROR_CODE + 1;
	
	/**
	 * Convenience method to read glyph characters from configuration file.
	 * @param config
	 * @param key &quot;human1&quot, &quot;human2&quot or &quot;computer&quot ;
	 * @return The glyph correspnding to <code>key</code>.
	 * @throws GameException
	 */
	private static char getGlyph(Properties config, String key) throws GameException {
		String value = config.getProperty(key).trim();
		
		if(value.length() != 1) {
			throw new GameException(
				String.format(
					"%s must be a string containing a single character. Its current value is %s",
					key,
					value
				),
				BAD_GLYPH_ERROR_CODE
			);
		}
		
		return value.charAt(0);
	}
	
	/**
	 * <p>Creates a new <code>com.metro.tictactoe.view.ConsoleView</code> out of a configuration file.</p>
	 * <p>See README.md and config/*.properties files for detailed examples.</p>
	 * @param input Input stream (web connection, physical file, etc) pointing to the resource that contains configuration settings. 
	 * @param reader Input reader through which the player sends his choices.
	 * @param writer Text writer used for feedback.
	 * @return A ready to use game view. Just call the <code>start</code> method to trigger the game.
	 * @throws GameException
	 */
	public static ConsoleView create(InputStream input, BufferedReader reader, PrintWriter writer) throws GameException{
		Properties config = new Properties();
		ConsoleView consoleView;
		
		try {
			
			config.load(input);
			
			int size = Integer.parseInt(config.getProperty("size"));
			char human1 = getGlyph(config, "human1");
			char human2 = getGlyph(config, "human2");
			char computer = getGlyph(config, "computer");
			GameController controller = new GameController(size);
			
			ChoiceInput[] inputs =  {
				new ConsoleChoiceInput(new Player(human1, "Human Player 1"), reader, writer),
				new ConsoleChoiceInput(new Player(human2, "Human Player 2"), reader, writer),
				new RandomChoiceInput(new Player(computer, "Bot Player"), controller.getState() , writer)
			};

			consoleView = new ConsoleView(inputs, controller);
			
		}catch (IOException e) {
			
			throw new GameException(e.getMessage(), CANT_READ_INPUT_ERROR_CODE);
			
		} catch(NumberFormatException e) {
			
			throw new GameException("The size property must contain an integer value.", SIZE_IS_NOT_INTEGER_ERROR_CODE);
			
		} catch(NullPointerException e) {
			
			throw new GameException("Some required properties are missing. Please review README.md for details.", MISSING_PROPERTY_ERROR_CODE);
			
		}

		
		return consoleView;
	}
	
	/**
	 * <p>Creates a new <code>com.metro.tictactoe.view.ConsoleView</code> out of a configuration file.</p>
	 * <p>See README.md and config/*.properties files for detailed examples.</p>
	 * @param configFile Path pointing to the configuration file.
	 * @param reader Input reader through which the player sends his choices.
	 * @param writer Text writer used for feedback.
	 * @return A ready to use game view. Just call the <code>start</code> method to trigger the game.
	 * @throws GameException
	 */
	public static ConsoleView create(String configFile, BufferedReader reader, PrintWriter writer) throws GameException{
		FileInputStream input;
		ConsoleView consoleView;
		
		try {
			
			input = new FileInputStream(configFile);
			consoleView = create(input, reader, writer);
		} catch (FileNotFoundException e) {
			
			throw new GameException(e.getMessage(), FILE_NOT_FOUND_ERROR_CODE);
			
		}
		
		return consoleView;
	}
}
