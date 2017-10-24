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
	 * <p>Helper function used by constructor to create the grid template.</p>
	 * <p>Check constructor's code for details.</p>
	 * @param space .-
	 * @param separator .-
	 * @param rows .-
	 * @param cols .-
	 * @param i .-
	 * @param EXTRA  .-
	 * @return .-
	 */
	private int fillRow(char space, char separator, int rows, int cols, int i, int EXTRA) {
		int col;
		char c;
		int k;
		
		grid[i * cols + 0] = space;
		grid[i * cols + 1] = space;
		
		for(k = 0; k < rows; k++) {
					
			col = k + EXTRA;
			c = k % 2 == 0 ? space : separator;
			grid[i * cols + col] = c;
		}

		return k;
	}
	
	/**
	 * 
	 * @param inputs 
	 * @param controller Controller that managesstate and game logic
	 * @param writer Print writer through which we send current game's state.
	 * @throws GameException
	 */
	public ConsoleView(ChoiceInput[] inputs, GameController controller, PrintWriter writer) throws GameException {
		super(inputs, controller);
		
		final int EXTRA = 2;		
		char[] lineSeparator = System.lineSeparator().toCharArray();
		int rows = 2 * controller.getState().getSize() + 1;
		int cols = rows + lineSeparator.length + EXTRA + 1;	
		int k = 0;
		
		this.grid = new char[  rows * cols ];
		this.writer = writer;
		
		for(int i = 0; i < rows; i++) {
			
			
			if( i % 2 == 0) { 
			
				k = fillRow(' ', '│', rows, cols, i, EXTRA);
				
			}else {
				
				k = fillRow('─', '┼', rows, cols, i, EXTRA);				
				grid[i * cols + k + EXTRA] = '─';
			}
							
			
			k ++;
			
			for(int j = 0 ; j < lineSeparator.length; j++) {
				
				int col = k + j + EXTRA;
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
