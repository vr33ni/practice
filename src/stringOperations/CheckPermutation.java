package stringOperations;

import java.util.Arrays;

public class CheckPermutation {

	static String sort(String s) {
		char[] arr = s.toCharArray();
		
		Arrays.sort(arr);
		System.out.println("Convert char arr to string " + Arrays.toString(arr) + " - Convert char array to actual string: " + new String(arr));
		return new String(arr);
	}
	
	static boolean isPermutation(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		}
		else {
			return sort(a).equals(sort(b));
		}
	}
	
	public static void main(String[]args) {
		String a = "dog";
		String b = "god";
		// it is assumed that the check here is case sensitive and that white space is significant
		System.out.println("is permutation: "+ isPermutation(a,b));
	}
}
