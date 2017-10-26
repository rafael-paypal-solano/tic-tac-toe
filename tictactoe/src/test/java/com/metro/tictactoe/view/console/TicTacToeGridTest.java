package com.metro.tictactoe.view.console;

import org.junit.Test;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;

public class TicTacToeGridTest {

	@Test
	 public void testCreateGrid() throws GameException {
		 
		 for(int i = GameController.MIN_SIZE; i < GameController.MAX_SIZE + 1; i++) {
			 
			 TicTacToeGrid grid = new TicTacToeGrid(i);
			 System.out.println();
			 System.out.println(grid);
		 }
	 }
}
