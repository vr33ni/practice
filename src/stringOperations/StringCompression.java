package stringOperations;

public class StringCompression {

	static String compress(String s) {
		//use loop
//		String compressed = "";
//		int charCounter = 1;
//
//		for (int i = 0; i < s.length(); i++) {
//			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
//				charCounter++;
//			} else {
//				compressed = compressed + s.charAt(i) + charCounter;
//				charCounter = 1;
//			}
//		}
//		if (compressed.length() > s.length()) {
//			return s;
//		}

		
		//use stringbuilder
		StringBuilder sb = new StringBuilder(); //more efficient than concatenation when used in for loops
		int charCounter = 1;

		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				charCounter++;
			} else {
				sb.append(s.charAt(i));
				sb.append(charCounter);
				charCounter = 1;
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "aabccccaaa";
		System.out.println(compress(s));
	}
}
