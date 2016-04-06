package app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Application properties 
 * 
 * 
 * @author Admin
 *
 */
public final class AppProperties {
	public static final String APP_PROPERTIES_FILE = "application.properties";	
	private static Properties properties = new Properties();
	
	@SuppressWarnings("unused")
	private static AppProperties instance = new AppProperties();
	
	/**
	 * Singleton. Load the application.properties
	 */
	private AppProperties() {
		try (InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(APP_PROPERTIES_FILE);) {
			properties.load(is);
			
		} catch (IOException e){
			throw new RuntimeException(e);
		} 
	}
	
	/**
	 * Load the class implementation of the computer brain level
	 * @return
	 */
	public static String getComputerBrainLevel() {
		return properties.getProperty("computer.brain.box.implementation");
	}
}
