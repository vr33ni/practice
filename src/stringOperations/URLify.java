package stringOperations;

public class URLify {

	static String urlify(String s, int n) {
		char[] arr = s.toCharArray();
		int spaces = countOfCharacters(arr, ' ');
				
		if (spaces < 1) { // string has no spaces, return unmodified
			return s;
		}
		
		// use string.replace or string.replaceAll (=takes a regex, but has some overhead)
//		s = s.trim(); //remove trailing and leading white spaces
//		String newString = s.replace(" ", "%20");
		
		// use string builder
		s = s.trim(); //remove trailing and leading white spaces
		StringBuilder sb = new StringBuilder();
	    for(char c : s.toCharArray()) {
	        if (c == ' ') {
	            sb.append("%20"); // need to use stringbuilder couse %20 is 3 characters and that cant be added to an array that already has a fixed size
	        } else {
	            sb.append(c);
	        }
	    }
	    
	    
		return sb.toString();
	}
	
	static int countOfCharacters(char[] arr, int target) {
		int spaces = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				spaces++;
			}
		}
		return spaces;
	}
	
	public static void main(String[] args) {
		String s = "Mr John Smith    ";
		int n = 13;
		System.out.println(urlify(s,n));
	}
}
