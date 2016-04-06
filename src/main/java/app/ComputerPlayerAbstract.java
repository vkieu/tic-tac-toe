package app;

public abstract class ComputerPlayerAbstract implements Player {
	protected CScreen screen;
	
	public ComputerPlayerAbstract(CScreen screen){
		this.screen = screen;
	}
	
	abstract public String getResponse();
	
	
	public String getPlayerName(){
		return "Computer";
	}
	
	public char getPlayerMarker() {
		return COMPUTER_MARKER;
	}
}
