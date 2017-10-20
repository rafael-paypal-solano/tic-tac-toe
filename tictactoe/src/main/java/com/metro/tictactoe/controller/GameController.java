package com.metro.tictactoe.controller;

import com.metro.tictactoe.model.Canvas;
import com.metro.tictactoe.model.Choice;

public class GameController {

	Canvas canvas;

	public GameController(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public void setChoice(Choice choice) {
		if(canvas.getPlayer(choice.getRow(), choice.getCol()) == null) {
			
		}
	}
}
