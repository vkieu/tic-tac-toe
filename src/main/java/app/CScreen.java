package app;

import java.util.HashMap;
import java.util.Map;

public class CScreen implements Cloneable {	
	private char[] theScreen = {
		' ',' ', 'A', ' ', 'B', ' ', 'C', '\n',//0-7, multiple of 8
		'1',' ', ' ', '|', ' ', '|', ' ', '\n',
		' ',' ', '-', '+', '-', '+', '-', '\n',
		'2',' ', ' ', '|', ' ', '|', ' ', '\n',
		' ',' ', '-', '+', '-', '+', '-','\n',
		'3',' ', ' ', '|', ' ', '|', ' ', '\n'		
	};  
	private Map<String, Integer> screenMap = new HashMap<>();
	private static final int FIRST_POS = 10;
	private static final int OFFSET = 16;
	private static final int STEP = 2;
	
	public CScreen() {
		//Initialise the screen
		//create a map of the replaceable characters 
		int currentPos = FIRST_POS;//first index
		
		screenMap.put(AppValidator.A1, currentPos + (OFFSET * 0));
		screenMap.put(AppValidator.A2, currentPos + (OFFSET * 1));
		screenMap.put(AppValidator.A3, currentPos + (OFFSET * 2));
		
		currentPos += STEP;
		screenMap.put(AppValidator.B1, currentPos + (OFFSET * 0));
		screenMap.put(AppValidator.B2, currentPos + (OFFSET * 1));
		screenMap.put(AppValidator.B3, currentPos + (OFFSET * 2));
		
		currentPos += STEP;
		screenMap.put(AppValidator.C1, currentPos + (OFFSET * 0));
		screenMap.put(AppValidator.C2, currentPos + (OFFSET * 1));
		screenMap.put(AppValidator.C3, currentPos + (OFFSET * 2));
	}
	
	public void prompt(String message) {
		System.out.println(message);
	}
	
	public void draw() {
		System.out.println(new String(theScreen));
	}
	
	public boolean unmark(String pos) {
		int index = screenMap.get(pos);
		theScreen[index] = ' ';
		return true;
	}
	
	public boolean mark(String pos, char c) {
		if(!hasMarker(pos)) {
			int index = screenMap.get(pos);
			theScreen[index] = c;
			return true;
		} 
		return false;
	}
	public boolean hasMarker(String pos) {
		return !hasMarker(pos, ' ');
	}
	
	public boolean hasMarker(String pos, char c) {
		return getMarker(pos) == c;
	}
	
	public char getMarker(String pos) {
		Integer index = screenMap.get(pos);
		if(index == null) {
			throw new IllegalStateException("Invalid marker specified ["+pos+"]");
		}
		return theScreen[index];
	}
	
	@Override
	public Object clone() {
		CScreen screen1 = new CScreen(); 
		screen1.screenMap = new HashMap<>(this.screenMap);
		screen1.theScreen = theScreen.clone();
		return screen1;
	}
}
