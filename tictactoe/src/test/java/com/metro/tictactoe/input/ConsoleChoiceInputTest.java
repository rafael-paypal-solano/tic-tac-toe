package com.metro.tictactoe.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Test;

import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ConsoleChoiceInputTest {
	
	public ConsoleChoiceInputTest() {
		
	}
	
	
	@Test
	public void testGoodInput() throws IOException {
		
		final String PLAYER_NAME = "Rafael Solano Martínez";
		
		InputStream input = ConsoleChoiceInputTest.class.getResourceAsStream("/com/metro/tictactoe/input/ConsoleChoiceInputTest.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		Player player = new Player('X', PLAYER_NAME);
		PrintWriter printer = new PrintWriter(System.out);
		ConsoleChoiceInput choiceInput = new ConsoleChoiceInput(player, reader, printer);
		Choice choice;
		
		Choice[] choices =  {
			new Choice(1,1,  new Player('X', PLAYER_NAME)),
			new Choice(2,3,  new Player('X', PLAYER_NAME)),
			new Choice(3,1,  new Player('X', PLAYER_NAME)),
			new Choice(3,4,  new Player('X', PLAYER_NAME)),
			new Choice(5,6,  new Player('X', PLAYER_NAME))
		};
		
		int i = 0;
		
		while((choice = choiceInput.read()) != null) {

			Assert.assertEquals(choices[i++], choice);
		}
	}
}
