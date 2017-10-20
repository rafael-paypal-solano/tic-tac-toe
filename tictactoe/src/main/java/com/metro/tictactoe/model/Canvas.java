package com.metro.tictactoe.model;

import java.io.Serializable;

/**
 * <p>TicTacToe canvas.</p>
 * @author rsolano
 *
 */
public class Canvas implements Serializable {

	/**
	 * <code>3</code>
	 */
	public static final int MIN_SIZE=3;
	
	/**
	 * <code>10</code>
	 */
	public static final int MAX_SIZE=10;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5162712967506426878L;

	/**
	 * Horiz/vert dimensions. Since the canvas is a square matrix, we only need to store a single <code>int</code>. 
	 */
	int size;
	
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
	}
	
	/**
	 * <p>Retrieves the <code>com.metro.tictactoe.model.Player</code> reference stored in a cell.</p>
	 * @param row Cell's vertical coordinate.
	 * @param col Cell's horizontal coordinate.
	 * @return The <code>com.metro.tictactoe.model.Player</code> stored in the cell identified by <code>row</code> and <code>col</code>.
	 */
	public Player getPlayer(int row, int col) {
		return players[row * size + col];
	}
	
	/**
	 * <p>Stores a <code>com.metro.tictactoe.model.Player</code> reference into an empty cell.</p>
	 * @param row Cell's vertical coordinate.
	 * @param col Cell's horizontal coordinate.
	 * @param player
	 * @return <code>true</code> if the cell at (row, col) is empty; if that's the case; if that's the case, the provided reference is stored in the empty cell.
	 */
	public boolean setPlayer(int row, int col, Player player) {
		if(getPlayer(row, col) == null) {
			players[row * size + col] = player;
			return true;
		}
		
		return false;
	}
}
