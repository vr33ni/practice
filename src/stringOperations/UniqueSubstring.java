package stringOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueSubstring {

	static Boolean isUniqueUsingAlphabetChars(String str, int i, int j) {
		// i and j can also be neglected and set to 0 and string length
		
		// Note : Default values in visited are false
		boolean[] visited = new boolean[26]; //26, only using alphabetic characters

		for (int k = i; k <= j; k++) {
			if (visited[str.charAt(k) - 'a'] == true) //takes an index from an ascii charater, otherwise it would be out of bounds every time
				return false;

			visited[str.charAt(k) - 'a'] = true;
		}
		return true;
	}


	
	
	
	static boolean isUniqueExtraDataStructureAssumingASCII(String s) {
		int MAX_CHAR = 256; // complete ASCI
		if (s.length() > MAX_CHAR)
			return false; // string must contain duplicates, if it is more than the max num of ascii
							// characters

		boolean[] chars = new boolean[MAX_CHAR];
		Arrays.fill(chars, false); // initially set all the values to false,

		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i);
			if (chars[index] == true)
				return false; // character has already been used => not unique
			else
				chars[index] = true; // character has now been used, so set to true in the chars array
		}
		return true;
	}

	static boolean isUniqueStreams(String s) {
		return s.chars().filter(e -> Collections.frequency(s.chars().boxed().collect(Collectors.toList()), e) > 1)
				.count() > 1 ? false : true;
	}

	
	static String findUniqueLongestSubstringBruteForce(String input) {
		int longest = 0;
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				String sub = input.substring(i, j);
				if (isUniqueExtraDataStructureAssumingASCII(sub)) {
					// determine the longest substring, and if the previously set longest is
					// shorter, then also set the current substring as result string
					if (longest < j - i + 1)
						result = sub;
					longest = Math.max(longest, j - i + 1);
				}
			}
			

		}
		return result;
	}

	static String findUniqueLongestSubstringUsingSet(String input) {

		String output = "";
		for (int i = 0; i < input.length(); i++) {
			Set<Character> visited = new HashSet<>(); //store characters that have already been seen
			int j = i;
			for (; j < input.length(); j++) {
				char currChar = input.charAt(j);
				if (visited.contains(currChar)) { // if the char has already been seen, break out of the loop
					break; // exits the inner for loop and stores the current substring
				} else {
					visited.add(currChar);
				}
			}

			if (output.length() < j - i + 1) { //output string is being set/reset, once the inner for loop is finished or broken out from
				output = input.substring(i, j);
			}
		}
		return output;
	}
	
	static String findUniqueLongestSubstringUsingMap(String input) {

		String output = "";
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			
				char currChar = input.charAt(i);
				if (map.get(currChar) != null) {
					map.put(currChar, map.get(currChar)+1); //increase count by 1
				}
				else map.put(currChar, 1);
			
//
//			if (output.length() < j - i + 1) { //output string is being set/reset, once the inner for loop is finished or broken out from
//				output = input.substring(i, j);
//			}
		}
		return output;
	}

	

    static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
        boolean uppercase = false;
        boolean lowercase = false;
        boolean special = false;
        boolean digit = false;
        
         String specialCharactersString = "!@#$%^&*()-+";
         int x=6;
          int missing = 0;
          
            
      

            for (int i =0; i<password.length(); i++) {
                 if(specialCharactersString.contains(Character.toString(password.charAt(i)))) {
                    special = true;
                }  
                if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                    uppercase = true;
                }
                if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                    lowercase = true;
                }
                if (password.charAt(i) >= 48 && password.charAt(i) <= 57) {
                    digit = true;
                }
            }
                    
          
           
            if (special == false) missing++;
            if (uppercase == false)missing++;
            if (lowercase == false) missing++;
            if (digit == false) missing++;
            
        if (n < x && x-n >= missing) return x-n;
        
        else return missing;
        
     
       
    }


	public static void main(String[] args) {

		String s = "abcdgaaadef";
//		System.out.println(findUniqueLongestSubstringBruteForce(s));
//		System.out.println(findUniqueLongestSubstringUsingSet(s));
		System.out.println(minimumNumber(4,"4700"));
	}
}
