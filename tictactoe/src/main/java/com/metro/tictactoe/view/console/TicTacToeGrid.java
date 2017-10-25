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
	 * @param size Since this is a square grid, size indicate both rows and columns count. This parameter must be in the [3,99] range.
	 * @param width A positive integer greater than 3.
	 */
	public TicTacToeGrid(int size, int width) {
		char[] lineSeparator = System.lineSeparator().toCharArray();
		int rows = 2 * (size + 1);
		int cols = (size + 1) * (width +  1) + lineSeparator.length + 1;
		int n = 1;
		
		this.size = size;
		this.grid = new char[  rows * cols ];
		
		
		for(int i = 0; i < rows -1; i += 2) {
			int j = i + 1;
			int k;
			char c = i < (rows - 2) ? '┼': '┴';
			
			for(k = 0; k < (cols - (lineSeparator.length + 1)) ; k++) {
				
				if(k > 0 && k % (width + 1) == 0) {
					
					grid[i * cols + k] = '│';
					grid[j * cols + k] = c;
				}else {
					
					grid[i * cols + k] = ' ';
					grid[j * cols + k] = '─';					
				}
			}
			
			if( i > 0 && i % 2 == 0) {
				
				if( n < 10) {
				
					grid[i * cols + 1] = (char)(n + 48);
				} else {
					
					grid[i * cols + 1] = (char)(n / 10 + 48);
					grid[i * cols + 0] = (char)((n - n / 10 ) + 48);
				}
				
				n++;
			}
			
			grid[i * cols + k] = '│';
			grid[j * cols + k] = i == rows -2 ? '┘' : '┤';
			
			for(int p = 0 ;p < lineSeparator.length; p++ ) {
				grid[i * cols + k + p + 1] = lineSeparator[p];
				grid[j * cols + k + p + 1] = lineSeparator[p];
				p++;
			}
			
		}		
	}

	@Override
	public String toString() {
		return new String(grid);
	}
	
	
}
