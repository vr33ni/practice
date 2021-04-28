package stringOperations;

public class LongestUniquePalindromeOfString {
	static String longestPalindrome(String s) {

		int n = s.length();
		String longest = "";

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String sub = s.substring(i, j + 1); // this is how to get all the substrings

				if (isPalindrome(sub)) {
					if (longest.length() < sub.length()) {
						longest = sub;
					}
				}

			}
		}

		return longest;

	}

	static boolean isPalindrome(String s) {
		StringBuilder reverse = new StringBuilder();
		String clean = s.replaceAll("\\s+", "").toLowerCase();
		char[] plain = clean.toCharArray();
		for (int i = plain.length - 1; i >= 0; i--) {
			reverse.append(plain[i]);
		}
		return (reverse.toString()).equals(clean);
	}

	public static void main(String[] args) {
		String p = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		System.out.println(longestPalindrome(p));
	}

}
