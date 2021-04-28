package stringOperations;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
    	
      	int deletions = 0;
    	for (int i = 0; i < s.length()-1; i++) {
          		if (s.charAt(i) == s.charAt(i+1)) {
        			deletions++;
        		}
    	}
    	
    	
    	return deletions;

    }

	
	public static void main(String[] args) {
		String test = "AAA";
		System.out.println(alternatingCharacters(test));
	}
}
