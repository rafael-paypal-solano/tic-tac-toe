package com.metro.tictactoe.view.console;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.junit.Test;

import com.metro.tictactoe.GameException;
import com.metro.tictactoe.view.ConsoleViewFactory;

public class ConsoleViewFactoryTest {

	private void assertExceptionCode(InputStream input, int code) throws GameException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);		
		
		try {
			
			ConsoleViewFactory.create(input, reader, writer);
			
		} catch(GameException e) {
			System.out.println(String.format("%s.assertExceptionCode --> %s", this.getClass().getName(), e.getMessage()));
			if(e.getCode() == code)
				throw e;
		}
		
	}
	
	@Test(expected = GameException.class )
	public void testFileNotFound() throws GameException {
		String configFile = "bogus.properties";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		
		try {
			
			ConsoleViewFactory.create(configFile, reader, writer);
			
		} catch(GameException e) {
			System.out.println(String.format("%s.testFileNotFound --> %s", this.getClass().getName(), e.getMessage()));
			if(e.getCode() == ConsoleViewFactory.FILE_NOT_FOUND_ERROR_CODE)
				throw e;			
		}
	}
	
	@Test(expected = GameException.class )
	public void testConfigWithMissingSize() throws GameException {
		InputStream input = this.getClass().getResourceAsStream("config-with-missing-size.properties");
		
		assertExceptionCode(input, ConsoleViewFactory.SIZE_IS_NOT_INTEGER_ERROR_CODE);
	}
	
	@Test(expected = GameException.class )
	public void testConfigWithMissingProperty() throws GameException {
		InputStream input = this.getClass().getResourceAsStream("config-with-missing-property.properties");
		
		assertExceptionCode(input, ConsoleViewFactory.MISSING_PROPERTY_ERROR_CODE);
	}
	
	@Test(expected = GameException.class )
	public void testConfigWithBadGlyphProperty() throws GameException {
		InputStream input = this.getClass().getResourceAsStream("config-with-bad-glyph.properties");
		
		assertExceptionCode(input, ConsoleViewFactory.BAD_GLYPH_ERROR_CODE);
	}	
}
