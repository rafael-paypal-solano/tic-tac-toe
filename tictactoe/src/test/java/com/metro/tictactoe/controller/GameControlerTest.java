package com.metro.tictactoe.controller;



import org.junit.Assert;
import org.junit.Test;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;
import com.metro.tictactoe.view.console.TicTacToeGrid;

public class GameControlerTest {
	
	
	public void assertValidStraightLine(GameController controller, TicTacToeGrid grid) throws GameException {
		boolean gameOver = controller.gameOver();
		
		System.out.println(gameOver);
		System.out.println(grid);
		Assert.assertEquals(gameOver, true);
	}
	
	@Test
	public void testValidStraightLines() throws GameException {
		
		Player player = new Player('X', "Rafael");
		
		/*
		 * Validates that vertical winning lines can be found.
		 */
		
		for(int size = GameController.MIN_SIZE; size < GameController.MAX_SIZE + 1; size++) {
			GameController leftDiagonalLineController = new GameController(size);
			GameController rightDiagonalLineController = new GameController(size);
			TicTacToeGrid leftDiagonalGrid = new TicTacToeGrid(size);
			TicTacToeGrid rightDiagonalGrid = new TicTacToeGrid(size);
			
			//TODO: Change back to GameController.MAX_SIZE + 1
			for(int i = 1; i < size + 1; i++) {
				GameController verticalLinesController = new GameController(size);
				GameController horizontalLinesController = new GameController(size);
				TicTacToeGrid verticalGrid = new TicTacToeGrid(size);
				TicTacToeGrid horizontalGrid = new TicTacToeGrid(size);
				
				leftDiagonalLineController.updateState(new Choice(i, i, player));
				rightDiagonalLineController.updateState(new Choice(i, size - (i - 1), player));
				leftDiagonalGrid.set(i, i, player.getGlyph());
				rightDiagonalGrid.set(i, size - (i - 1), player.getGlyph());				
				
				for(int k = 1; k < size + 1; k++) {					
					verticalLinesController.updateState(new Choice(k, i, player));
					horizontalLinesController.updateState(new Choice(i, k, player));										
					verticalGrid.set(k, i, player.getGlyph());
					horizontalGrid.set(i, k, player.getGlyph());
				}
							
				assertValidStraightLine(verticalLinesController, verticalGrid);
				assertValidStraightLine(horizontalLinesController, horizontalGrid);
			}
			
			assertValidStraightLine(leftDiagonalLineController, leftDiagonalGrid);
			assertValidStraightLine(rightDiagonalLineController, rightDiagonalGrid);			
		}
	}
	
	public void assertInvalidStraightLine(GameController controller, TicTacToeGrid grid) throws GameException {
		boolean gameOver = controller.gameOver();
		
		System.out.println(gameOver);
		System.out.println(grid);
		Assert.assertEquals(gameOver, false);
	}
	
	 
	//@Test
	public void testInvalidStraightLines() throws GameException {
		Player player1 = new Player('X', "Rafael");
		Player player2 = new Player('O', "Raul");
		
		/*
		 * Validates that vertical winning lines can be found.
		 */
		
		for(int size = GameController.MIN_SIZE; size < GameController.MAX_SIZE+1; size++) {
			for(int i = 1; i < size + 1; i++) {
				GameController verticalLinesController = new GameController(size);
				GameController horizontalLinesController = new GameController(size);
				TicTacToeGrid verticalGrid = new TicTacToeGrid(size);
				TicTacToeGrid horizontalGrid = new TicTacToeGrid(size);
				
				
				for(int k = 1; k < size + 1; k++) {
					Player player = i == k ? player1 : player2; 
					
					verticalLinesController.updateState(new Choice(k, i, player));
					horizontalLinesController.updateState(new Choice(i, k, player));
					
					verticalGrid.set(k, i, player.getGlyph());
					horizontalGrid.set(i, k, player.getGlyph());
				}
							
				assertInvalidStraightLine(verticalLinesController, verticalGrid);
				assertInvalidStraightLine(horizontalLinesController, horizontalGrid);
			}
		}

	}	
	
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
