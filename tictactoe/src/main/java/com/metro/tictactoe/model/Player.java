package com.metro.tictactoe.model;

import java.io.Serializable;

/**
 * <p>TicTacToe player.</p>
 * @author rsolano
 *
 */
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6019919520196710190L;

	/**
	 * Character used to represent this player.
	 */
	private char glyph;
	
	/**
	 * Player name.
	 */
	private String name;

	/**
	 * Empty constructor to make this class match java beans standard.
	 */
	public Player() {
		
	}
	/**
	 * Initializes fields whose names match parameters.
	 * @param glyph Character used to represent this player.
	 * @param name Player name.
	 */
	public Player(char glyph, String name) {
		super();
		this.glyph = glyph;
		this.name = name;
	}

	/**
	 * 
	 * @return Character used to represent this player.
	 */
	public char getGlyph() {
		return glyph;
	}

	/**
	 * 
	 * @param glyph Character used to represent this player.
	 */
	public void setGlyph(char glyph) {
		this.glyph = glyph;
	}

	/**
	 * 
	 * @return Player name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name Player name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "{name:\"" + name + "\"}";
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
		Player other = (Player) obj;
		if (glyph != other.glyph)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
