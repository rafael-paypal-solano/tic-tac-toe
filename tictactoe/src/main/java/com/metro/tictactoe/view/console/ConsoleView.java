package com.metro.tictactoe.view.console;


import java.io.PrintWriter;
import com.metro.tictactoe.GameException;
import com.metro.tictactoe.controller.GameController;
import com.metro.tictactoe.input.ChoiceInput;
import com.metro.tictactoe.view.GameView;

/**
 *  <p>This game view displays the game's state into print writer .</p>
 * @author rsolano
 *
 * System.lineSeparator().length()
 */
public class ConsoleView extends GameView{

	/**
	 * 
	 */
	char grid[];

	/**
	 * Print writer through which we send current game's state.
	 */
	PrintWriter writer;
	
	/**
	 * 
	 * @param inputs 
	 * @param controller Controller that managesstate and game logic
	 * @param writer Print writer through which we send current game's state.
	 * @throws GameException
	 */
	public ConsoleView(ChoiceInput[] inputs, GameController controller, PrintWriter writer) throws GameException {
		super(inputs, controller);
		
		char[] lineSeparator = System.lineSeparator().toCharArray();
		int rows = 2 * controller.getState().getSize() + 1;
		int cols = rows + lineSeparator.length + 2;	
		char c;  
		int col;
		int k;
		
		this.grid = new char[  rows * cols ];
		this.writer = writer;
		
		for(int i = 0; i < rows; i++) {
			
			if( i % 2 == 0) { 
				
				grid[i * cols + 0] = ' ';
				grid[i * cols + 1] = ' ';
				
				for(k = 0; k < rows; k++) {
							
					col = k + 2;
					c = k % 2 == 0 ? ' ' : '│';
					grid[i * cols + col] = c;
				}
				
				
				
			}else {
				
				grid[i * cols + 0] = '─';
				grid[i * cols + 1] = '─';
				
				for(k = 0; k < rows; k++) {
					
					col = k + 2;
					c = k % 2 == 0 ? '─' : '┼';
					grid[i * cols + col] = c;
				}				
			}
			
			for(int j = 0 ; j < lineSeparator.length; j++) {
				
				col = k + j + 2;
				grid[i * cols + col] = lineSeparator[j];
			}
		}
		
		
	}

	@Override
	public void displayState() {
		String text = new String(this.grid);
		writer.println(text);
	}
	

}
