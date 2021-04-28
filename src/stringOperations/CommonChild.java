package stringOperations;

public class CommonChild {
	
	static int longestCommonChild(String original, String compare) {
		int longest = 0;
		
		if (original.length() > 5000 || compare.length() > 5000) {
			return 0;
		}
		
		for (int i = 0; i < compare.length(); i++) {
			//check if one or more single char from the compare string is present in the original one
			if (original.indexOf(compare.charAt(i))!=-1) {
				longest=1; //one or more single char from the compare string is present in the original string
			}
			if (i+1<compare.length() && (original.indexOf(compare.charAt(i)) != -1 && original.indexOf(compare.charAt(i+1)) != -1)) {
				longest = 2;
			}
		}
		
		
		return longest;
	}

	public static void main(String[]args) {
		String s = "AA";
		String t = "AABB";
		System.out.println(longestCommonChild(s,t));
	}
}

