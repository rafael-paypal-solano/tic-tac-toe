package com.metro.tictactoe.model;

import java.io.Serializable;

/**
 * This class represents a cell's coordinates.
 * @author rsolano
 *
 */
public class Choice implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3828422703871529896L;

	/**
	 *  Vertical coordinate.
	 */
	int row;
	
	/**
	 * Horizontal coordinate.
	 */
	int col;

	/**
	 * Player who made the choice.
	 */
	Player player;
	
	/**
	 * Empty constructor to make this class match java beans standard.
	 */
	public Choice() {
		
	}
	/**
	 * 
	 * @param row Vertical coordinate.
	 * @param col Horizontal coordinate.
	 * @param player Player who made the choice
	 */
	public Choice(int row, int col, Player player) {
		super();
		this.row = row;
		this.col = col;
		this.player = player;
	}

	/**
	 * 
	 * @return Vertical coordinate.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * 
	 * @param row Vertical coordinate.
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * 
	 * @return Horizontal coordinate.
	 */
	public int getCol() {
		return col;
	}

	/**
	 * 
	 * @param col  Horizontal coordinate.
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
	/**
	 * 
	 * @return Player who made the choice.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * 
	 * @param player Player who made the choice
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	@Override
	public String toString() {
		return "{row:" + row + ", col:" + col + ", player:" + player + "}";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Choice other = (Choice) obj;
		if (col != other.col)
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
}
