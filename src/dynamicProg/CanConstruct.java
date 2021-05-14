package dynamicProg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanConstruct {

	static boolean canConstructRecursive(String target, List<String> compare) {

		if (target.compareTo("") == 0)
			return true;
		for (String s : compare) {
			if (target.indexOf(s) == 0) {
				String suffix = target.substring(s.length());
				if (canConstructRecursive(suffix, compare)) {
					return true;
				}
			}
		}
		return false;
	}

	

	static boolean canConstructMemoization(String target, List<String> compare) {
		HashMap<String, Boolean> memo = new HashMap<>();
		return canConstructMemoization(target, compare, memo);
	}

	static boolean canConstructMemoization(String target, List<String> compare, HashMap<String, Boolean> memo) {
		if (memo.containsKey(target))
			return memo.get(target);

		if (target.compareTo("") == 0)
			return true;

		for (String s : compare) {
			if (target.indexOf(s) == 0) {
				String suffix = target.substring(s.length());
				if (canConstructRecursive(suffix, compare)) {
					memo.put(target, true);
					return true;
				}
			}
		}
		memo.put(target, false);
		return false;
	}

	static boolean canConstructTabulation(String target, List<String> compare) {

		boolean[] table = new boolean[target.length() + 1];
		table[0] = true;

		for (int i = 0; i <= target.length(); i++) {
			if (table[i] == true) {
				for (String s : compare) {
					if (i + s.length() <= target.length()) {
						table[i + s.length()] = true;
					}
				}
			}
		}
		return table[target.length()];
	}

	public static void main(String[] args) {
		String target = "Parkour";
		List<String> compare = new ArrayList<>();
		compare.add("Pk");
		compare.add("Park");
		compare.add("ou");
		compare.add("r");
		String s1 = "AABB";
		String s2 = "AACC";
//		System.out.println(canConstructRecursive(target, compare));
//		System.out.println(canConstructMemoization(target, compare));
//		System.out.println(canConstructTabulation(target, compare));

	}
}
