package stringOperations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class MakeAnagram {
	static int makeAnagram(String first, String second) {
		int deletions = 0;
		
		 HashMap<String, Integer> map = new HashMap<>();
		 StringBuilder a = new StringBuilder(first);
//		 StringBuilder b = new StringBuilder(second);
         
         for(int i = 0; i < first.length(); i++) {
             String key = Character.toString(first.charAt(i));
            
             map.merge(key, 1, Integer::sum);
                          }
         for(int i = 0; i < second.length(); i++) {
             String key = Character.toString(second.charAt(i));
             StringBuilder b = new StringBuilder(second);
             
             map.merge(key, 1, Integer::sum);
             
             if (map.containsKey(key) && map.get(key) > 1) {
            	 b.deleteCharAt(i);
            	 second = b.toString();
             }
         }
         // Remove the specified entry from the Map
         map.entrySet()
             .removeIf(
                 entry -> (entry.getValue() < 2));
       
         
         deletions = (first.length() + second.length()) - map.size();
//        
//		int[] freqFirst = new int[26];
//        int[] freqSecond = new int[26];
//        
//        for(int i = 0; i < first.length(); i++)
//            freqFirst[first.charAt(i)-'a'] = freqFirst[first.charAt(i)-'a'] + 1; //Increment frequency of char at i
//        for(int i = 0; i < second.length(); i++)
//            freqSecond[second.charAt(i)-'a'] = freqSecond[second.charAt(i)-'a'] + 1; //Increment frequency of char at i
//        
//        for(int i = 0; i < 26; i++)
//            deletions += Math.abs(freqFirst[i] - freqSecond[i]); //Track the total deletions needed
//        
        return deletions;
		}

	
	 static String superReducedString(String s) {
		    // Write your code here
		  
		    int i = 1;

		    while (i < s.length()) {
		        if (s.charAt(i) == s.charAt(i-1)) {
		            s = s.substring(0, i-1) + s.substring(i+1);
		            s = superReducedString(s);
		            i++;
		        }
		        i++;
		        
		    }
		    return s;

		    }

	 
	 
	public static void main(String[] args) {
		String a = "showman";
		String b = "woman";
		String t = "aaabccddd";
		System.out.println(makeAnagram(a, b));
		System.out.println(superReducedString(t));
	}

}
