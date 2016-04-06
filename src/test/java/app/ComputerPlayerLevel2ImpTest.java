package app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({CScreen.class})
public class ComputerPlayerLevel2ImpTest {
	private Player player;
	private CScreen screen;
	
	@Before
	public void setUp() throws Exception {
		screen = Mockito.mock(CScreen.class);
		player = new ComputerPlayerLevel2Imp(screen);
	}

	@Test
	public void testGetResponse() {
		when(screen.clone()).thenReturn(screen);
		assertNotNull(player.getResponse());		
		Mockito.verify(screen, times(1)).clone();		
		Mockito.verify(screen, times(1)).hasMarker("A1");
		Mockito.verify(screen, times(1)).hasMarker("A2");
		Mockito.verify(screen, times(1)).hasMarker("A3");
		Mockito.verify(screen, times(1)).mark("A1", 'X');
		Mockito.verify(screen, times(1)).mark("A2", 'X');
		Mockito.verify(screen, times(1)).mark("A3", 'X');
		Mockito.verify(screen, times(1)).unmark("A1");
		Mockito.verify(screen, times(1)).unmark("A2");
		Mockito.verify(screen, times(1)).unmark("A3");
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
