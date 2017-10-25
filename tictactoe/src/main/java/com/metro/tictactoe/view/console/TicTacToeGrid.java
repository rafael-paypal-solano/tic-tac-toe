package com.metro.tictactoe.view.console;

import java.util.Arrays;

/**
 * <p>This class provides convenience methods to draw the tic-tac-toe grid.</p>
 * @author rsolano
 *
 */

public class TicTacToeGrid {
	/**
	 * Text buffer.  
	 */
	char grid[];	

	/**
	 *  Since this is a square grid, size indicate both rows and columns count.
	 */
	int size;
	
	/**
	 * 
	 * @param size Since this is a square grid, size indicate both rows and columns count.
	 * @param 
	 */
	public TicTacToeGrid(int size, int width) {
		char[] lineSeparator = System.lineSeparator().toCharArray();
		int rows = 2 * (size + 1);
		int cols = (size + 1) * (width +  1) + lineSeparator.length;
		
		this.size = size;
		this.grid = new char[  rows * cols ];
		
		
		for(int row = 0; row < rows -1; row += 2) {
			int i = row;
			int j = row + 1;
			int k;
			
			for(k = 0; k < (cols - lineSeparator.length) ; k++) {
				
				if(k > 0 && k % (width + 1) == 0) {					
					grid[i * cols + k] = '│';
					grid[j * cols + k] = '┼';
				}else {
					grid[i * cols + k] = ' ';
					grid[j * cols + k] = '─';					
				}
			}
			
			
			int p = 0;
			
			while(p < lineSeparator.length) {
				grid[i * cols + k + p] = lineSeparator[p];
				grid[j * cols + k + p] = lineSeparator[p];
				p++;
			}
			
		}		
	}

	@Override
	public String toString() {
		return new String(grid);
	}
	
	
}
