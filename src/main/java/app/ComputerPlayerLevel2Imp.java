package app;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayerLevel2Imp extends ComputerPlayerLevel1Imp implements Player {

	public ComputerPlayerLevel2Imp(CScreen screen) {
		super(screen);
	}

	@Override
	public String getResponse() {
		//clone the screen to check for winning next move
		CScreen screenClone = (CScreen)screen.clone();
		//clone possible inputs
		List<String> possibleInputClone = new ArrayList<>(this.possibleInput);
		for(String pos : possibleInputClone) {
			if(!screenClone.hasMarker(pos)) {
				screenClone.mark(pos, Player.PLAYER_MARKER);
				if(AppValidator.isWinner(Player.PLAYER_MARKER, screenClone)) {
					this.possibleInput.remove(pos);
					return pos;
				}
				screenClone.unmark(pos);
			}
		}				
		return super.getResponse();
	}

}