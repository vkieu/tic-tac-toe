package app;

public class PlayerFactory {
	public static Player createComputerPlayer(CScreen screen) {
		//base on application.properties, load the appropriate algorithm to play the game
		try {
			String impl = AppProperties.getComputerBrainLevel();		
			Player obj = (Player) Class.forName(impl).getConstructor(CScreen.class).newInstance(screen);				
			return obj;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
}
