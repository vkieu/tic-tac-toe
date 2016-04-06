package app;

public class LogicController {
	
	private CScreen screen;
	private Player computer;
	private Player player1;
	
	public LogicController() {
		//Initialise the screen
		screen = new CScreen();
		//Initialise computer brain power level
		computer = PlayerFactory.createComputerPlayer(screen);
		player1 = new KeyboardPlayer(screen);
	}
	
	private boolean answerNo(String response) {
		return "n".equalsIgnoreCase(response)
				|| "no".equalsIgnoreCase(response);
	}
	
	private String getValidResponse(Player player) {
		String response = player.getResponse();
		while(response != null){
			boolean isValid = AppValidator.isValidResponse(response) && !screen.hasMarker(response); 
			if(isValid) {
				return response;				
			} 
			screen.prompt(player.getPlayerName() + ", Invalid response! Please try again?");
			response = player.getResponse();
		}		
		return response;
	}
	
	private Player playerStart() {
		while(true) {
			screen.draw();
			screen.prompt(player1.getPlayerName() + " Please enter your next move?");
			String input = getValidResponse(player1);
			screen.mark(input, player1.getPlayerMarker());
			if(AppValidator.isWinner(player1.getPlayerMarker(), screen)) {
				return player1;
			} else if(AppValidator.isADraw(screen)) {
				return null;
			}
			input = getValidResponse(computer);
			if(input != null) {
				screen.mark(input, computer.getPlayerMarker());
				if(AppValidator.isWinner(computer.getPlayerMarker(), screen)) {
					return computer;
				} else if(AppValidator.isADraw(screen)) {
					return null;
				}
			}
		}
	}
	
	private Player computerStart() {
		while(true) {
			String input = getValidResponse(computer);
			if(input != null) {
				screen.mark(input, computer.getPlayerMarker());
				if(AppValidator.isWinner(computer.getPlayerMarker(), screen)) {
					return computer;
				} else if(AppValidator.isADraw(screen)) {
					return null;
				}			
			}
			screen.draw();
			screen.prompt(player1.getPlayerName() + " Please enter your next move?");
			input = getValidResponse(player1);
			screen.mark(input, player1.getPlayerMarker());
			if(AppValidator.isWinner(player1.getPlayerMarker(), screen)) {
				return player1;
			} else if(AppValidator.isADraw(screen)) {
				return null;
			}			
		}
	}
	
	public void play() {
		//ask player1 who want to go first? COMPUTER or PLAYER1
		screen.prompt(player1.getPlayerName() + ", Do you want to go first? (Y)");
		String response = player1.getResponse();		
		boolean playerGoFirst = response != null && !answerNo(response);
		Player winner = null;
		if(playerGoFirst) {
			winner = playerStart();
		} else {
			winner = computerStart();
		}
		screen.draw();
		if(winner != null) {
			screen.prompt(winner.getPlayerName() + " is the Winner!");
		} else {
			screen.prompt("It is a Draw!");
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LogicController().play();
	}

}
