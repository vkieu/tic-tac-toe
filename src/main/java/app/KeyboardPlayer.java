package app;

import java.io.IOException;

public class KeyboardPlayer implements Player{
	
	@SuppressWarnings("unused")
	private CScreen screen;	
	
	public KeyboardPlayer(CScreen screen) {
		this.screen = screen;
	}	
	
	public String getResponse() {
		return getInputResponse();
	}
	
	@Override
	public String getPlayerName() {
		return "Player1";
	}

	@Override
	public char getPlayerMarker() {
		return PLAYER_MARKER;
	}
	
	private String getInputResponse() {
		try {
			byte[] buffer = new byte[1024*1];//1k
			int length = System.in.read(buffer);
			return new String(buffer, 0, length).trim(); 					
		} catch (IOException ioe) {
			throw new IllegalArgumentException(ioe);
		}
	}
	
}
