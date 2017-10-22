package com.metro.tictactoe.input;

import com.metro.tictactoe.model.Player;

import java.io.IOException;

import com.metro.tictactoe.model.Choice;

/**
 * This class represents the stream of choices made by a player.
 * @author rsolano
 *
 */
public abstract class ChoiceInput {
	
	/**
	 * The player who makes the choices.
	 */
	Player player;
	
	/**
	 * 
	 * @param player The player who makes the choices.
	 */
	public ChoiceInput(Player player) {
		
		this.player = player;
	}
	
	/**
	 * 
	 * @return The next choice made by the user or <code>null</code> if there EOF has been reached.
	 * @throws IOException 
	 */
	public abstract Choice read() throws IOException;

	/**
	 * 
	 * @return The player who makes the choices.
	 */
	public Player getPlayer() {
		return player;
	}
	
	
	
}
