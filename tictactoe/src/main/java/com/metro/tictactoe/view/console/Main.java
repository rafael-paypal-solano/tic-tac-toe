package com.metro.tictactoe.view.console;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.metro.tictactoe.GameException;

public class Main {


	
	/**
	 * 
	 * @param args -
	 * @throws GameException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String args[]) throws GameException {
		ConsoleView view;
		
		try {
			
			if(args.length < 1) {
				
				throw new GameException("Usage: java -jar target/tictactoe.jar <input-file>");
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(System.out);
			view = ConsoleViewFactory.create(args[0], reader, writer);
			view.start();
			
		}catch(GameException e) { //GameException catches logic violations and also wraps relevant JVM exceptions
			
			if(e.getCause() == null) { // if cause is null, then e caught a logic violation which is gracefully reported.
				
				System.out.println(e.getMessage());
				
			} else { // if cause is not null, then a really bad JVM exception occurred; the full stacktrace is displayed.
				
				throw e;
				
			}
			
		}
	}
}
