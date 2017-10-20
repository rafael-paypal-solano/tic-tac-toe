package com.metro.tictactoe.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ComputerChoiceInputTest {
	
	public ComputerChoiceInputTest() {
		
	}
	
	
	@Test
	public void testGoodInput() throws IOException {
		
		
		InputStream input = ComputerChoiceInputTest.class.getResourceAsStream("/com/metro/tictactoe/input/ComputerChoiceInputTest.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		Player player = new Player('X', "Rafael Solano Martínez");
		ConsoleChoiceInput choiceInput = new ConsoleChoiceInput(player, reader);
		Choice choice;
		
		Choice[] choices =  {
			new Choice(1,1,  new Player('X', "Rafael Solano Martínez")),
			new Choice(2,3,  new Player('X', "Rafael Solano Martínez")),
			new Choice(3,1,  new Player('X', "Rafael Solano Martínez"))
		};
		
		int i = 0;
		
		while((choice = choiceInput.read()) != null) {
			
			Assert.assertEquals(choices[i++], choice);
			System.out.println(choice);
		}
	}
}
