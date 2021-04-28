package stringOperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SherlockAndTheValidString {

	 static String isValid(String s) {
		 
//		 HashSet<String> set = new HashSet();
//		 
//		 for (int i = 0; i<s.length(); i++) {
//			 set.add(Character.toString(s.charAt(i)));
//		 }
//		 
//		 if (s.length() % set.size() > 1) {
//			 return "NO";
//		 }
//		 
//		 else return "YES";
//	    }
		 int notValid = 0;
		 
		 HashMap<String,Integer> map = new HashMap();
		 for (int i = 0; i<s.length(); i++) {
			   String key = Character.toString(s.charAt(i));
	           map.merge(key, 1, Integer::sum);
		 }

		 
		  Set<Integer> st = new HashSet<>();
	        for(int freq : map.values())
	        {
	            st.add(freq);
	        }
	        
	        
	        int f1 = 0;
	        int f2 = 0;
	        int f1Count = 0;
	        int f2Count = 0;
	        int i=0;
	        
	        if (st.size() == 2) {
	        	for (int n : st) {
	        		if (i==0) {
	        			f1 = n;
	        		} else f2 =n;
	        		i++;	
	        	}
	        	
	        	for (int frequency : map.values()) {
	        		if (frequency == f1) {
	        			f1Count++;
	        		}
	        		if (frequency == f2) {
	        			f2Count++;
	        		}
	        	}
	        	
	        	if ((f1 == 1 && f1Count == 1) || (f2==1 && f2Count ==1)) {
	        		return "YES";
	        	}
	        	else if ((Math.abs(f1-f2) == 1) && (f1Count == 1 || f2Count == 1)) {
	        		return "YES";
	        	}
	        	else return "NO";
	        }
	        
	        else if (st.size() == 1) {
	        	return "YES";
	        }
	        else {
	        	return "NO";
	        }
//		 Integer[] values = map.values().toArray(new Integer[map.size()]);
//		 Arrays.sort(values);
//		 
//		 for (int i = 0; i < values.length; i++) {
//			 System.out.println(values[i]);
//		 }
//		 
//		 int key = values[0];
//		 for (int i = 0; i < values.length; i++) {
////		   for (int j = i+1; j<values.length; j++) {
//		     if (values[i] > key) {
//		       notValid = notValid + values[i];
//		     }
////		   }
//		 }
		 
//		if (notValid - key > 1) {
//			return "NO";
//
//		} else return "YES";
	 }
	
	public static void main(String[] args) {
		String s = "aabbc";
		System.out.println(isValid(s));
	}
}
