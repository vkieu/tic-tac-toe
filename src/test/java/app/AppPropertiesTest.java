package app;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AppPropertiesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetComputerBrainLevel() {
		assertNotNull(AppProperties.getComputerBrainLevel());
	}

}
