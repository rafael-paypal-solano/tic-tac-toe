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
		
		for(int size = GameController.MIN_SIZE; size < GameController.MAX_SIZE+1; size++) {
			for(int i = 1; i < size + 1; i++) {
				GameController verticalLinesController = new GameController(size);
				GameController horizontalLinesController = new GameController(size);
				TicTacToeGrid verticalGrid = new TicTacToeGrid(size);
				TicTacToeGrid horizontalGrid = new TicTacToeGrid(size);
				
				for(int k = 1; k < size + 1; k++) {
					
					verticalLinesController.updateState(new Choice(k, i, player));
					horizontalLinesController.updateState(new Choice(i, k, player));
					
					verticalGrid.set(k, i, player.getGlyph());
					horizontalGrid.set(i, k, player.getGlyph());
				}
							
				assertValidStraightLine(verticalLinesController, verticalGrid);
				assertValidStraightLine(horizontalLinesController, horizontalGrid);
			}
		}
	}
	
	public void assertInvalidStraightLine(GameController controller, TicTacToeGrid grid) throws GameException {
		boolean gameOver = controller.gameOver();
		
		System.out.println(gameOver);
		System.out.println(grid);
		Assert.assertEquals(gameOver, false);
	}
	
	 
	@Test
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
}
