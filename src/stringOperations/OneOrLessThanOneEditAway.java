package stringOperations;

import java.util.HashSet;

public class OneOrLessThanOneEditAway {

	static boolean isOneOrZeroReplacementsAway(String original, String compare) {
		int found = 0;
		for (int i = 0; i<original.length();i++) {
			for (int j = 0; j<compare.length(); j++) {
				if (original.charAt(i) == compare.charAt(j)) { //if the char from original string is found in the compare string, increase the character found counter
					found++;
				}
			}
		
		}
		if (found == original.length()-1 || found == original.length()) return true; // if the number of characters from the original string found in the compare string is the same length as the original or length - 1, return true
		else return false;
	}
	
	static boolean isOneInsertionAway(String original, String compare) {
		
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		String longer = "";
		String shorter = "";
		
		if (original.length()>compare.length()) {
			longer=original;
			shorter=compare;
		} else {
			longer=compare;
			shorter=original;
		}
		
		while (index1 < longer.length() && index2 < shorter.length()) {
			if (longer.charAt(index1) != shorter.charAt(index2) ) {
				if (foundDifference) return false;
				else foundDifference = true;
				index1++;
			}
			else {
				index1++;
				index2++;
			}
		}
		return true;
	}
	
	static boolean isOneOrZeroEditsAway(String original, String compare) {
		
		if (original.length() - compare.length() > 1) { //the string length already indicates there has been more than 1 edit
			return false;
		}
		else if (original.length() == compare.length()) { // equal string length indicates a replacement, since insertion or removal would mean unequal length
			return isOneOrZeroReplacementsAway(original, compare);
		}
		else return isOneInsertionAway(original, compare);
	}
	
	public static void main(String[]args) {
	
		String original = "pale";
		String compare = "pal";
		System.out.println(isOneOrZeroEditsAway(original,compare)); 
	}
}
