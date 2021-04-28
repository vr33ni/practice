package stringOperations;

import java.util.Arrays;

public class FindSpecifiedSubstrings {

	static int numOfSpecialStrings(int n, String s) {
		if (n != s.length()) {
			return 0;
		}
		
		int count = 0;
		boolean isAllTheSame = false;


		for (int i = 0; i < s.length(); i++) {
			//each char counts as a special substring, so take these first
			count++;

			// another case is the one of two adjacent elements having the same value
			if (i+1 < s.length()) {
				if (s.charAt(i) == s.charAt(i+1)){
					count++;
					isAllTheSame = true;
				}
				else isAllTheSame =  false;
			}
			//and the last case is the one where all characters except the middle one are the same
			if (i+2 < s.length() && s.charAt(i) == s.charAt(i+2)) {
				count++;
			}
		}
		//and the case if all elements are the same
		if (isAllTheSame) count++;
		

		return count;
	}
	
	public static void main(String[]args) {
		int n = 4;
		String s = "aaaa";
		System.out.print(numOfSpecialStrings(n, s));
	}
}
