package com.metro.tictactoe;

import com.metro.tictactoe.model.Player;

/**
 * <p>This class represent current game's state.</p>
 * @author rsolano
 *
 */
public interface GameState {
	/**
	 * <p>Retrieves the <code>com.metro.tictactoe.model.Player</code> reference stored in a cell.</p>
	 * @param row Cell's vertical coordinate.
	 * @param col Cell's horizontal coordinate.
	 * @return The <code>com.metro.tictactoe.model.Player</code> stored in the cell identified by <code>row</code> and <code>col</code>.
	 */
	public Player getPlayer(int row, int col);
	
	
	/**
	 * 
	 * @return How many cells where filled in previous moves.
	 */
	public int getCount();
	
	/**
	 * 
	 * @return Horiz/vert dimensions. Since the canvas is a square matrix, we only need to store a single int.
	 */
	public int getSize();
		
	/**
	 * 
	 * @param row  Cell's vertical coordinate.
	 * @param col Cell's horizontal coordinate.
	 * @return <code>true</code> if the <code>row</code> &amp; <code>col</code> coordinates are inside the game grid.
	 */
	public boolean isValidCoordinate(int row, int col);
}
