package stringOperations;

import java.util.HashMap;

public class CompareStrings {

	static boolean isOneOrZeroEditsFromOriginal(String original, String toCheck) {
		int charFound = 0;
		String longer = "";
		String shorter = "";

		if (original.length() == toCheck.length()) { // possiblity of zero edits
			// compare char by char
			for (int i = 0; i < original.length(); i++) {
				charFound = 0; // repeat the check for existance for each char of the original string
				for (int j = 0; j < toCheck.length(); j++) {
					if (original.charAt(i) != toCheck.charAt(j)) {
						charFound++;
					}
				}
			}
			if (charFound == original.length() || Math.abs(charFound - original.length()) == 1) {
				return true;
			} else
				return false;
		} else if (Math.abs(original.length() - toCheck.length()) == 1) { // possibility of 1 edit		
			if (original.length() > toCheck.length()) {
				longer = original;
				shorter = toCheck;
			} else {
				longer = toCheck;
				shorter = original;
			}

			int k = 0;
			charFound = 0;

			for (int i = 0; i < shorter.length(); i++) {
//				System.out.println(shorter.charAt(k));
					if (shorter.charAt(i) == longer.charAt(k)) {
						charFound++;
					}
					System.out.print(longer.charAt(k));
					k++;

				

			}
			if (k == shorter.length()) {
				k = 0;
			}

			System.out.println();

		}

		else
			return false; // other than 1 or 0 edits so return false

		if (Math.abs(charFound - longer.length()) == 1) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		String original = "pale";
		String toCheck = "pal";
		System.out.println(isOneOrZeroEditsFromOriginal(original, toCheck));
	}
}
