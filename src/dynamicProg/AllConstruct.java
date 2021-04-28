package dynamicProg;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AllConstruct {

	static List<List<String>> allConstructRecursive(String target, List<String> compare) {

		if (target.compareTo("") == 0) { // base case => return a 2d empty array
		if (target.compareTo("") == 0) {
			return new ArrayList<>(Arrays.asList(new ArrayList<>()));
		} // empty 2d array list

		List<List<String>> result = new ArrayList<>(); // the final collection of sub arrays that can make up the target
														// string

		for (String s : compare) {
			if (target.indexOf(s) == 0) { // when the target string contains s, and it starts at index 0 (e.g. "climb"
											// => "cli")
//				System.out.println(s);
				String suffix = target.substring(s.length()); // basically target string minus some substring's length
																// that starts with the same characters
				List<List<String>> suffixWays = allConstructRecursive(suffix, compare); // all the ways the new suffix
																						// can be generated
				List<List<String>> targetWays = new ArrayList<>();
				for (int i = 0; i < suffixWays.size(); i++) {
					List<String> temp = suffixWays.get(i); // get the elements making up the suffix
					temp.add(s);
					targetWays.add(temp);

				}
				for (int i = 0; i < targetWays.size(); i++) {
					result.add(new ArrayList<>(targetWays.get(i)));
				}
			}

		}
		return result;
		}
		return null;
	}

	static List<List<String>> allConstructMemoization(String target, List<String> compare) {
		HashMap<String, List<List<String>>> memo = new HashMap<>();
		return allConstructMemoization(target, compare, memo);
	}

	static List<List<String>> allConstructMemoization(String target, List<String> compare,
			HashMap<String, List<List<String>>> memo) {
		if (memo.containsKey(target))
			return memo.get(target);

		if (target.compareTo("") == 0)
			return new ArrayList<>(Arrays.asList(new ArrayList<>())); // why dis?

		List<List<String>> result = new ArrayList<>();

		for (String s : compare) {
			if (target.indexOf(s) == 0) {
				String suffix = target.substring(s.length());

//				List<List<String>> suffixWays = allConstructRecursive(suffix, compare); // 2d array of all the ways to
				// build the suffix
//				List<List<String>> targetWays = new ArrayList<>(); // how the suffixways can be used to build the
				// original target (in this case add String s in
				// front of it)
				List<List<String>> suffixWays = allConstructMemoization(suffix, compare, memo);
				List<List<String>> targetWays = new ArrayList<>();

				for (int i = 0; i < suffixWays.size(); i++) {
					List<String> temp = suffixWays.get(i);
					temp.add(s);
					targetWays.add(temp);
				}

				for (int i = 0; i < targetWays.size(); i++) {
					result.add(new ArrayList<>(targetWays.get(i)));
				}
			}
		}
		memo.put(target, result);
		return result;
	}

	// dynamic programming
	// m=target.length, n=compare.length
	// each leave of the tree is one way to create the target string
	// height of the tree = m
	// O(n^m) leaves = combinations to generate the target string => O(n^m)
	// subarrays => exponential time complecity
	// O(m) space
	static List<List<String>> allConstruct(String target, List<String> compare,
			HashMap<String, List<List<String>>> memo) {
		if (memo.containsKey(target))
			return memo.get(target);

		if (target.compareTo("") == 0) { // base case => return a 2d empty array
			if (target.compareTo("") == 0) {
				return new ArrayList<>(Arrays.asList(new ArrayList<>()));
			} // empty 2d array list

			List<List<String>> result = new ArrayList<>(); // the final collection of sub arrays that can make up the
															// target
															// string

			for (String s : compare) {
				if (target.indexOf(s) == 0) { // when the target string contains s, and it starts at index 0 (e.g.
												// "climb"
												// => "cli")
//				System.out.println(s);
					String suffix = target.substring(s.length()); // basically target string minus some substring's
																	// length
																	// that starts with the same characters
					List<List<String>> suffixWays = allConstructRecursive(suffix, compare); // all the ways the new
																							// suffix
																							// can be generated
					List<List<String>> targetWays = new ArrayList<>();
					for (int i = 0; i < suffixWays.size(); i++) {
						List<String> temp = suffixWays.get(i); // get the elements making up the suffix
						temp.add(s);
						targetWays.add(temp);

					}
					for (int i = 0; i < targetWays.size(); i++) {
						result.add(new ArrayList<>(targetWays.get(i)));
					}
				}

			}

			return result;
		}
		return null;

	}

	static List<List<String>> allConstruct(String target, List<String> compare) {
		HashMap<String, List<List<String>>> memo = new HashMap();
		return allConstruct(target, compare, memo);

	}

	static List<List<String>> allConstructTabulation(String target, List<String> compare) {
		// 3d list because we have one collection (outer list) that consists of various
		// substrings (2nd list) that can be created based on various combinations
		// (inner lists)
		List<List<List<String>>> table = new ArrayList<>(Collections.nCopies(target.length() + 1, null));

		// iterate over the table to initialize an empty array list for each position
		for (int i = 0; i <= target.length(); i++) {
			table.set(i, new ArrayList<>()); // add the 2nd layer - an empty array at each index, indicating how the
												// substring up to but not including the current index can be generated
		}
		table.get(0).add(new ArrayList<>()); // set an empty array as the innermost array (3d) at position 0, which is
												// our seed base case

		for (int i = 0; i <= target.length(); i++) {
			for (String s : compare) {
				if (target.substring(i).indexOf(s) == 0) { // check if the substring starting from index i contains
															// element s
					List<List<String>> combinations = new ArrayList<>();
					for (List<String> subArray : table.get(i)) {
						List<String> subArrayTemp = new ArrayList<>(subArray);
						subArrayTemp.add(s);
						combinations.add(subArrayTemp);
					}

					// add the combinations at this index to the outer collection of all possible
					// combinations
					for (List<String> subArray : combinations) {
						table.get(i + s.length()).add(new ArrayList<>(subArray));

					}

				}
			}
		}
		return table.get(target.length());
	}

	public static void main(String[] args) {
		String target = "Parkour";
		List<String> compare = new ArrayList<>();
		compare.add("Pk");
		compare.add("Park");
		compare.add("ou");
		compare.add("r");
//		System.out.println(allConstructRecursive(target, compare));
//		System.out.println(allConstructMemoization(target, compare));
		System.out.println(allConstructTabulation(target, compare));
	}
}
