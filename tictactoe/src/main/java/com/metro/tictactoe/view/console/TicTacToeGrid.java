package com.metro.tictactoe.view.console;

import java.util.Arrays;

import com.metro.tictactoe.GameException;

/**
 * <p>This class provides convenience methods to draw the tic-tac-toe grid.</p>
 * <p>Notice that the grid can accommodate more cells than specified.</p>
 * @author rsolano
 *
 */

public class TicTacToeGrid {
	/**
	 * <code>Min grid size.</code>
	 */
	public static final int MIN_SIZE=3;
	
	/**
	 * <code>Max grid size</code>
	 */
	public static final int MAX_SIZE=10;

	
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
	 * @throws GameException 
	 */
	public TicTacToeGrid(int size) throws GameException {
		
		if (size < MIN_SIZE || size > MAX_SIZE)
			throw new GameException("Grid size if out of range.", -1);
		
		final int width = 3;
		char[] lineSeparator = System.lineSeparator().toCharArray();
		int rows = 2 * (size + 1);
		int cols = (size + 1) * (width +  1) + lineSeparator.length + 1;
		int n = 1;
		int pos = 2 * width;
		
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
					grid[pos] = grid[i * cols + 1];
				} else {
					
					grid[i * cols + 0] = (char)(n/size + 48);
					grid[i * cols + 1] = (char)(n - (n/size) * 10 + 48);
					
					grid[pos + 1] = grid[i * cols + 1];
					grid[pos] = grid[i * cols + 0];
				}
				
				pos += (width+1);
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
