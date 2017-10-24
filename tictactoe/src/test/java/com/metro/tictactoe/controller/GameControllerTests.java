package com.metro.tictactoe.controller;

import org.junit.Test;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;

public class GameControllerTests {

	@Test
	public void testGoodInitialization() throws GameException {
		for(int i = GameController.MIN_SIZE; i < GameController.MAX_SIZE; i++) {			
			new GameController(i);
			System.out.println(String.format("%s.testGoodInitialization --> Created game controler of size %d", getClass().getName(), i));
		}
	}
	
	@Test(expected = GameException.class)
	public void testBadInitializationMin() throws GameException {
		new GameController(GameController.MIN_SIZE-1);
	}
	
	@Test(expected = GameException.class)
	public void testGoodInitializationMax() throws GameException {
		new GameController(GameController.MAX_SIZE+1);
	}	
}
