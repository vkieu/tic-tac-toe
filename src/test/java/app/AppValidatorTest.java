package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AppValidatorTest {

	private CScreen screen;
	
	@Before
	public void setUp() throws Exception {
		screen = new CScreen();	
	}

	@Test
	public void testGetPossibleGridInput() {
		assertNotNull(AppValidator.getPossibleGridInput());		
	}

	@Test
	public void testIsValidResponse() {
		assertFalse(AppValidator.isValidResponse("A4"));
		assertFalse(AppValidator.isValidResponse("AA"));
		assertFalse(AppValidator.isValidResponse("D1"));
		assertFalse(AppValidator.isValidResponse(null));
		
		assertTrue(AppValidator.isValidResponse("A1"));
		assertTrue(AppValidator.isValidResponse("A2"));
		assertTrue(AppValidator.isValidResponse("A3"));
		
		assertTrue(AppValidator.isValidResponse("B1"));
		assertTrue(AppValidator.isValidResponse("B2"));
		assertTrue(AppValidator.isValidResponse("B3"));
		
		assertTrue(AppValidator.isValidResponse("C1"));
		assertTrue(AppValidator.isValidResponse("C2"));
		assertTrue(AppValidator.isValidResponse("C3"));
	}

	@Test
	public void testIsADraw() {
		assertFalse(AppValidator.isADraw(screen));
	}

	@Test
	public void testIsWinner() {
		assertFalse(AppValidator.isWinner(Player.COMPUTER_MARKER, screen));
		screen.mark(AppValidator.A1, Player.COMPUTER_MARKER);
		assertFalse(AppValidator.isWinner(Player.COMPUTER_MARKER, screen));
		screen.mark(AppValidator.A2, Player.COMPUTER_MARKER);
		assertFalse(AppValidator.isWinner(Player.COMPUTER_MARKER, screen));
		screen.mark(AppValidator.A3, Player.COMPUTER_MARKER);
		assertTrue(AppValidator.isWinner(Player.COMPUTER_MARKER, screen));
	}

}
