package app;

interface Player {
	
	public static final char PLAYER_MARKER = 'X';
	public static final char COMPUTER_MARKER = 'O';
	
	public String getResponse();
	public String getPlayerName();
	public char getPlayerMarker();
}
