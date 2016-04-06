package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComputerPlayerLevel1ImpTest {
	private Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new ComputerPlayerLevel1Imp(new CScreen());
	}

	@Test
	public void testGetResponse() {
		assertNotNull(player.getResponse());
	}

	@Test
	public void testComputerPlayerLevel1Imp() {
		assertNotNull(player);
	}

	@Test
	public void testGetPlayerName() {
		assertTrue("Computer".equals(player.getPlayerName()));
	}

	@Test
	public void testGetPlayerMarker() {
		assertTrue('O' == player.getPlayerMarker());
	}

}
