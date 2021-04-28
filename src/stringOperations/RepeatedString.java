package stringOperations;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/* 
There is a string, s, of lowercase English letters that is repeated infinitely many times. 
Given an integer, n,  find and print the number of letter a's in the first n letters of the infinite string.

Example
The substring we consider is abcacabcac, the first 10 characters of the infinite string.
There are 4 occurrences of a in the substring.

Function Description
Complete the repeatedString function in the editor below.
repeatedString has the following parameter(s):
    s: a string to repeat
    n: the number of characters to consider
*/
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) { 
    	
    	//APPROACH I - FAST
    	long aCounter = 0;

    	//if input is only 1 character and this character equals the searched for character, theres no need to append the string until n
    	String searchS = "a";
    	char searchC = searchS.charAt(0);
    	if (s.length() == 1 && s.charAt(0) == searchC) { 
        		return n;
    	}
    	
    	for (int i = 0 ; i < s.length(); i++) {
    		if (s.charAt(i) == 'a') {
    			aCounter ++;
    		}
    	}
    	 
    	// faster approach , dont build the string as previously attempted, takes too long
    	long howManyTimes = n/s.length();
    	long remainder = n%s.length();
    	aCounter = howManyTimes * aCounter;
    	
    	for (int j = 0; j < remainder; j++) {
    		if (s.charAt(j) == 'a') {
    			aCounter ++;
    		}
    	}
    	
    	//APPROACH II - SLOW
    	//if input is only 1 character and this character equals the searched for character, theres no need to append the string until n
//    	String searchS = "a";
//    	char searchC = searchS.charAt(0);
//    	if (s.length() == 1 && s.charAt(0) == searchC) { 
//        		return n;
//    	}
    	
//    	//make sure the input string has at least the length of n - if not, repeat the characters until it does
//    	if (s.length() < n) {
//    		int i = s.length();
//    		int j = 0;
//    		StringBuilder str = new StringBuilder(s);
//    		while (i < n) {
//    				str = str.append(s.substring(j, j+1));
//    				s = str.toString();
//
//        			System.out.println(str.toString());
//    				j++;
//        			i++;
//    		}
//    	}
//          
//    	String nOfString = s.substring(0,(int)n);
//    	char[] charAr = nOfString.toCharArray();
//    	int aCounter = 0;
//    	String searchString = "a";
//    	char searchChar = searchString.charAt(0);
//    	
//    	for (int i = 0 ; i < charAr.length; i++) {
//    		if (charAr[i] == searchChar) {
//    			aCounter ++;
//    		}
//    	}
    	return aCounter;

    }

	
	public static void main(String[] args) {
		String s = "a";
		long n = 1000000000000L;
		System.out.println("A is found: " + repeatedString(s, n) + " times in the given string.");
	}
}
