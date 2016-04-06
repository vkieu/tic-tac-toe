package app;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * @author Admin
 *
 */
public class AppValidator {
	public static final String A1 = "A1";
	public static final String A2 = "A2";
	public static final String A3 = "A3";
	public static final String B1 = "B1";
	public static final String B2 = "B2";
	public static final String B3 = "B3";
	public static final String C1 = "C1";
	public static final String C2 = "C2";
	public static final String C3 = "C3";
	
	private static Set<String> possibleGridInput = new HashSet<>();	
	@SuppressWarnings("unused")
	private static AppValidator instance = new AppValidator();	
	
	private AppValidator() {
		possibleGridInput.add(A1);
		possibleGridInput.add(A2);
		possibleGridInput.add(A3);
		possibleGridInput.add(B1);
		possibleGridInput.add(B2);
		possibleGridInput.add(B3);
		possibleGridInput.add(C1);
		possibleGridInput.add(C2);
		possibleGridInput.add(C3);		
	}

	public static Set<String> getPossibleGridInput() {
		return Collections.unmodifiableSet(possibleGridInput);
	}
	
	public static boolean isValidResponse(String input) {
		return possibleGridInput.contains(input);
	}
	
	public static boolean isADraw(CScreen screen) {
		for(String pos : possibleGridInput) {
			if(!screen.hasMarker(pos)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isWinner(char marker, CScreen screen) {
		//winner formulae		
		return
			//horizontal
			  (screen.hasMarker(AppValidator.A1, marker) && screen.hasMarker(AppValidator.A2, marker) && screen.hasMarker(AppValidator.A3, marker))
			||(screen.hasMarker(AppValidator.B1, marker) && screen.hasMarker(AppValidator.B2, marker) && screen.hasMarker(AppValidator.B3, marker))
			||(screen.hasMarker(AppValidator.C1, marker) && screen.hasMarker(AppValidator.C2, marker) && screen.hasMarker(AppValidator.C3, marker))
			//vertical
			||(screen.hasMarker(AppValidator.A1, marker) && screen.hasMarker(AppValidator.B1, marker) && screen.hasMarker(AppValidator.C1, marker))
			||(screen.hasMarker(AppValidator.A2, marker) && screen.hasMarker(AppValidator.B2, marker) && screen.hasMarker(AppValidator.C2, marker))
			||(screen.hasMarker(AppValidator.A3, marker) && screen.hasMarker(AppValidator.B3, marker) && screen.hasMarker(AppValidator.C3, marker))
			//diagonals
			||(screen.hasMarker(AppValidator.A1, marker) && screen.hasMarker(AppValidator.B2, marker) && screen.hasMarker(AppValidator.C3, marker))
			||(screen.hasMarker(AppValidator.A3, marker) && screen.hasMarker(AppValidator.B2, marker) && screen.hasMarker(AppValidator.C1, marker))
			;
	}
	
}
