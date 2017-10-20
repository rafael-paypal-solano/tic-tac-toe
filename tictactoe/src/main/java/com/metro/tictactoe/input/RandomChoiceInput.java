package com.metro.tictactoe.input;

import java.io.IOException;

import com.metro.tictactoe.model.CanvasState;
import com.metro.tictactoe.model.Choice;
import com.metro.tictactoe.model.Player;

public class RandomChoiceInput extends ChoiceInput{

	CanvasState canvas;
	int size;
	
	public RandomChoiceInput(Player player, CanvasState canvas) {
		super(player);
		this.canvas = canvas;
		this.size = canvas.getSize() * canvas.getSize();
	}

	@Override
	public Choice read() throws IOException {
		if(canvas.getCount() < this.size) {
			int row = (int)(Math.random() * 100);
			int col = (int)(Math.random() * 100);
			
			while(canvas.getPlayer(row, col) != null) {
				row = (int)(Math.random() * 100);
				col = (int)(Math.random() * 100);
				
				return new Choice(row, col, this.player);
			}
		}
		return null;
	}

}
