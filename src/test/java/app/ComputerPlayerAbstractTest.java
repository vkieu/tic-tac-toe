package app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComputerPlayerAbstractTest {
	private Player player;	
	@Before
	public void setUp() throws Exception {
		player = new ComputerPlayerAbstract(new CScreen()) {			
			@Override
			public String getResponse() {
				return null;
			}
		};
	}

	@Test
	public void testComputerPlayerAbstract() {
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
