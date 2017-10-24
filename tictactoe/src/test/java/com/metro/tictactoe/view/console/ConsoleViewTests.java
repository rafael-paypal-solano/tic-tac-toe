package com.metro.tictactoe.view.console; 

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Test;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;

public class ConsoleViewTests {

	@Test
	public void testDisplay() throws GameException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		
		for(int j = GameController.MIN_SIZE; j < GameController.MAX_SIZE + 1; j++) {
			
			String resourceName = String.format("test-display-%d.properties", j);
					
			writer.println(String.format("%s.testDisplay --> %s", getClass().getName(), resourceName));
			writer.flush();
			InputStream input = this.getClass().getResourceAsStream(resourceName);
			ConsoleView consoleView = ConsoleViewFactory.create(input, reader, writer);
			consoleView.displayState();
		}
	}
}
