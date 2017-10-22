package com.metro.tictactoe;

/**
 * <p>This exception class is used to report violations to game logic and also wraps (when necessary)
 * relevant JVM exceptions.</p>
 * @author rsolano
 *
 */
public class GameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8196213975631832880L;

	/**
	 * Used for debugging.
	 */
	private int code ;
	
	/**
	 * 
	 * @param message The detail message (which is saved for later retrieval by the getMessage() method).
	 * @param cause the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public GameException(String message, Throwable cause) {
		
		super(message, cause);		
	}

	/**
	 * 
	 * @param message The detail message (which is saved for later retrieval by the getMessage() method).
	 */
	public GameException(String message) {
		
		super(message);
	}

	/**
	 * 
	 * @param message The detail message (which is saved for later retrieval by the getMessage() method).
	 * @param code Integer value used for debugging.
	 */
	public GameException(String message, int code) {
		
		super(message);
		this.code = code;
	}
	
	/**
	 * 
	 * @param cause the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and indicates that the cause is nonexistent or unknown.)
	 */
	public GameException(Throwable cause) {
		
		super(cause);
	}

	/**
	 * 
	 * @return Integer value used for debugging.
	 */
	public int getCode() {
		return code;
	}

	
}
