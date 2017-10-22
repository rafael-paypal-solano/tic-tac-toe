package com.metro.tictactoe.view;


import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;
import com.metro.tictactoe.input.ChoiceInput;

public class ConsoleView {

	GameController controller;
	ChoiceInput[] inputs;
	
	public ConsoleView(
		ChoiceInput[] inputs,
		GameController controller
	) throws GameException {
	
		this.inputs = inputs;
		this.controller = controller;
	}
	public void start() {
		
	}
	

}
