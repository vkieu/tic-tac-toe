package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayerLevel1Imp extends ComputerPlayerAbstract implements Player {

	protected List<String> possibleInput;
	
	public ComputerPlayerLevel1Imp(CScreen screen) {
		super(screen);
		this.possibleInput = new ArrayList<String>(AppValidator.getPossibleGridInput());
	}
	
	@Override
	public String getResponse() {
		int index = getRandom();
		if(index > -1) {
			//remove from memory
			return possibleInput.remove(index);
		}
		return null;
	}
	
	protected int getRandom() {
		Random rand = new Random(System.currentTimeMillis());	
		if(possibleInput.size() > 0) {
			return rand.nextInt(possibleInput.size());
		} 
		return -1;
	}
	

}
