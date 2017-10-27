package com.metro.tictactoe.model;

import com.metro.tictactoe.GameState;

/**
 * <p>TicTacToe canvas.</p>
 * @author rsolano
 *
 */
public class Canvas implements GameState {

	

	/**
	 * Horiz/vert dimensions. Since the canvas is a square matrix, we only need to store a single <code>int</code>. 
	 */
	int size;
	
	/**
	 * How many cells where filled in previous moves.
	 */
	int count;
	
	/**
	 * <p>This is a <b><code>size * size</code></b> vector representing the game state.</p>
	 */
	Player[] players;
	
	/**
	 * Empty constructor to make this class match java beans standard.
	 */
	public Canvas() {
		
	}
	/**
	 * <p>Creates the internal <code>players</code> vector</p>
	 * @param size
	 */
	public Canvas(int size) {
		this.players = new Player[size * size];		
		this.size = size;
	}
	
	/**
	 * <p>Retrieves the <code>com.metro.tictactoe.model.Player</code> reference stored in a cell.</p>
	 * @param row Cell's vertical coordinate.
	 * @param col Cell's horizontal coordinate.
	 * @return The <code>com.metro.tictactoe.model.Player</code> stored in the cell identified by <code>row</code> and <code>col</code>.
	 */
	public Player getPlayer(int row, int col) {
		return players[(row - 1) * size + (col - 1)];
	}
	
	/**
	 * <p>Stores a <code>com.metro.tictactoe.model.Player</code> reference into an empty cell.</p>
	 * @param row Cell's vertical coordinate.
	 * @param col Cell's horizontal coordinate.
	 * @param player
	 * @return <code>true</code> if the cell at (row, col) is empty; if that's the case; if that's the case, the provided reference is stored in the empty cell.
	 */
	public boolean setPlayer(int row, int col, Player player) {
		
		if(
			getPlayer(row, col) == null &&
			isValidCoordinate(row, col)
		) { 
			
			players[(row - 1) * size + (col-1)] = player;
			count ++;
			return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return How many cells where filled in previous moves.
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * 
	 * @return Horiz/vert dimensions. Since the canvas is a square matrix, we only need to store a single int.
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isValidCoordinate(int row, int col) {

		return (
			(row > 0 && row < size + 1) &&
			(col > 0 && col < size + 1)
		);
	}
	
	
}
