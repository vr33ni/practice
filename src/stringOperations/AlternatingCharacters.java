package stringOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AlternatingCharacters {

    public static int alternate(String s) {
    	int len = s.length();
    	 Set<Character> distinct = new HashSet<>();
         for (int i = 0; i < len; i++) {
             distinct.add(s.charAt(i));
         }
  
         List<Character> distinctList = new ArrayList<>(distinct);
  
         int max = 0;
         for(int i = 0; i < distinct.size() - 1; i++) {
             for(int j = i + 1; j < distinct.size() ; j++) {
                 char c1 = distinctList.get(i);
                 char c2 = distinctList.get(j);
                 String subset = s.replaceAll("[^" + c1 + "" + c2 + "]", "");
                 if(isAlternating(subset)) {
                     int l = subset.length();
                     max = l > max ? l : max;
                 }
             }
         }
     return max;
    }
      private static boolean isAlternating(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
	
      static String removeRepeated(String str) {
    	  StringBuilder sb = new StringBuilder();
    	  Set<Character> linkedHashSet = new LinkedHashSet<>();

    	  for (int i = 0; i < str.length(); i++) {
    	      linkedHashSet.add(str.charAt(i));
    	  }

    	  for (Character c : linkedHashSet) {
    	      sb.append(c);
    	  }
    	  return sb.toString();
      }
      
	public static void main(String[] args) {
		String test = "beabeefeab";
		System.out.println(alternate(test));
		System.out.println(removeRepeated(test));

	}
}
