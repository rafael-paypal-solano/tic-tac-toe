package com.metro.tictactoe.controller;

import com.metro.tictactoe.model.Canvas;
import com.metro.tictactoe.model.Player;

/**
 * Helper thread used by GameController to find straight winning lines.
 * @author rsolano
 *
 */
class StraightLineScanner implements Runnable {
	/**
	 * Indicates whether we have a winning line (horizontal or vertical)
	 */
	boolean complete;
	
	/**
	 * pivot position.
	 */
	int i;

	/**
	 * <p>TicTacToe canvas.</p>
	 */
	Canvas canvas;	
	/**
	 * <p>Resets internal fields. Call this method before submitting to the executor.</p>
	 * @param canvas TicTacToe canvas.
	 * @param i pivot position.
	 */
	public void reset(Canvas canvas, int i) {
		
		this.i = i;
		this.complete = false;
		this.canvas = canvas;
		
	}
	
	/** 
	 *  <p>Implements the scanning process</p>
	 */
	public void run() {
		int size = canvas.getSize();
		Player top = canvas.getPlayer(1, i);
		Player topLeft = canvas.getPlayer(1, 1);		
		Player left = canvas.getPlayer(i, 1);
		Player topRight = canvas.getPlayer(1, size);
		
		int verticalCount = 0;
		int horizontalCount = 0;
		int leftDiagonalCount = 0;
		int rightDiagonalCount = 0;
		
		for(int k = 1; k < size + 1; k++) {
			int j = size - (k - 1);
			
			verticalCount += canvas.getPlayer(k, i) != null && canvas.getPlayer(k, i) == top ? 1 : 0;			
			horizontalCount += canvas.getPlayer(i, k) != null  && canvas.getPlayer(i, k) == left ? 1 : 0;
			leftDiagonalCount += canvas.getPlayer(k, k) != null &&  canvas.getPlayer(k, k) == topLeft ? 1 : 0;
			rightDiagonalCount += canvas.getPlayer(j, size - (j - 1)) != null &&  canvas.getPlayer(j, size - (j - 1)) == topRight ? 1 : 0;
		}
		
		complete = (
			verticalCount == canvas.getSize() ||
			horizontalCount == canvas.getSize() || 
			leftDiagonalCount == canvas.getSize() ||
			rightDiagonalCount == canvas.getSize()
		);
	}
	
	/**
	 * 
	 * @return <code>true</code> if a winning line was found. This value may be different across different calls to <code>this.start</code>.
	 */
	public boolean isComplete() {
		return complete;
	}		
}	
