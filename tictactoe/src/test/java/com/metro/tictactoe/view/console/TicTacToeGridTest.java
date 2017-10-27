package com.metro.tictactoe.view.console;

import org.junit.Test;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;

public class TicTacToeGridTest {

	@Test
	 public void testCreateGrid() throws GameException { //Validates that ArrayIndexOutOfBoundsException is thrown by TicTacToeGrid constructor. 
		 
		 for(int i = GameController.MIN_SIZE; i < GameController.MAX_SIZE + 1; i++) {
			 
			 TicTacToeGrid grid = new TicTacToeGrid(i);
			 System.out.println();
			 
			 for(int j = 0; j < i; j++) {
				 
				 for(int k = 0; k < i; k++) {
					 grid.set(j+1, k+1, 'X');
				 }
			 }
			 System.out.println(grid);
		 } 
	 }
}
