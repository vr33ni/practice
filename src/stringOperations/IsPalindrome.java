package stringOperations;

import java.util.Arrays;
import java.util.HashMap;

public class IsPalindrome {
	static boolean isPalindrome(String s) {
		StringBuilder reverse = new StringBuilder();
		String clean = s.replaceAll("\\s+", "").toLowerCase();
		char[] plain = clean.toCharArray();
		for (int i = plain.length - 1; i >= 0; i--) {
			reverse.append(plain[i]);
		}
		return (reverse.toString()).equals(clean);
	}

	static boolean isPalindromeSimple(String text) {
		String clean = text.replaceAll("\\s+", "").toLowerCase();
		int length = clean.length();
		int forward = 0;
		int backward = length - 1;
		while (backward > forward) {
			char forwardChar = clean.charAt(forward++);
			char backwardChar = clean.charAt(backward--);
			if (forwardChar != backwardChar)
				return false;
		}
		return true;
	}

	static boolean isPalindromeRecursive(String text, int forward, int backward) {
		if (forward == backward) {
			return true;
		}
		if ((text.charAt(forward)) != (text.charAt(backward))) {
			return false;
		}
		if (forward < backward + 1) {
			return isPalindromeRecursive(text, forward + 1, backward - 1);
		}

		return true;
	}

	static boolean isPalindromeTwoPointers(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}


	public static void main(String[] args) {
		String s = "abbcbba";
		System.out.println(isPalindrome(s));
		System.out.println(isPalindromeSimple(s));
		System.out.println(isPalindromeRecursive(s, 0, s.length() - 1));
		System.out.println(isPalindromeTwoPointers(s));
	}
}
