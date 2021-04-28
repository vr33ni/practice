package stringOperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Pattern;

//check if a string is a permutation of a palindrome 
//casing and non-letter characters can be ignored.
public class PalindromePermutation {

	static boolean isPalindromePermutation(String inputString) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		boolean isOdd = false;
		boolean isEven = false;

		String a = inputString.replace(" ", "");
		
		if (a.length() % 2 == 0) { // even length, meaning each character has to appear twice
			isEven = true;
		} else { // odd length, meaning each character has to appear twice, besides one, which
					// can appear only once
			isOdd = true;
		}

	    // Creating a HashMap containing char
        // as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap
            = new HashMap<Character, Integer>();
  
        // Converting given string to char array
  
        char[] strArray = a.toLowerCase().toCharArray();
  
        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {
  
                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else {
  
                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }
        }
  
		int nrOfSingleChars = 0;

        // Printing the charCountMap
		for (Integer val : map.values()) {
		    // ...
		
            System.out.println(val);
            if (isEven && val == 2) {
            	return true;
            }
            else if (isOdd && val == 1) {
            	nrOfSingleChars ++;
            }
            else return false;
        }
        
		
		if (nrOfSingleChars > 1) { 
			return false;
		} else
			return true;
	}
	
	
	
	static boolean isPalindromePermutation2(String s) {

		HashMap<Character, Integer> charCount = new HashMap<>();
		boolean isEven = false;
		int nrOfSingleChars = 0;
		int[] arr = new int[26];

		if (s.length() % 2 == 0) {
		    isEven = true;
		}
		for (int i=0; i<s.length(); i++) {
		    if (charCount.containsKey(s.charAt(i))) {
		        charCount.put(s.charAt(i),charCount.get(s.charAt(i)) + 1);
		        nrOfSingleChars --;
		    }
		    else {
		        charCount.put(s.charAt(i), 1);
		        nrOfSingleChars ++;
		    }
		}
		for (Integer val : charCount.values()) {
		    if (val > 2) return false;
		}

		if (!isEven && nrOfSingleChars == 1) return true;
		if (isEven && nrOfSingleChars > 1) return false;

		return true;
		}  

	
	static boolean isPalindromePermutation3(String s) {

		HashMap<Character, Integer> charCount = new HashMap<>();
		boolean isEven = false;
		int nrOfSingleChars = 0;
		int[] arr = new int[26];
		Arrays.fill(arr, 0);

		if (s.length() % 2 == 0) {
			isEven = true;
		}
		
		
		
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLetterOrDigit(s.charAt(i)))return false;
			if (arr[s.charAt(i) - 'a'] < 0) return false;
			else if (arr[s.charAt(i) - 'a'] == 0) {
				arr[s.charAt(i) - 'a'] = 1;
				nrOfSingleChars++;
			} else
				arr[s.charAt(i) - 'a'] = arr[s.charAt(i) - 'a'] + 1;
			nrOfSingleChars--;
		}

		if (!isEven && nrOfSingleChars == 1)
			return true;

		for (int i = 0; i < arr.length; i++) {
			if (isEven && arr[i] % 2 != 0)
				return false;
		}
		return true;
	}


	public static void main(String[] args) {
		String s = "tact coa";
		String p = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//		System.out.println(isPalindromePermutation(s));
		System.out.println(isPalindromePermutation2(s));
		System.out.println(isPalindromePermutation3(s));

	}
}
