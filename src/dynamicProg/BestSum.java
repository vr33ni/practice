package dynamicProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestSum {
	// recursive approach
	// time: O(n^m * m) - m=targetsum; n=numbers.length;
	// branching factor (n) to the height factor (m), additional operations: copying
	// over the array (worst case of length n, e.g. a bunch of 1s in an array)
	// space complexity: O(m^2) height: m, shortestCombination List (worst case m in
	// length) => in eaach of the operations you need to store an array
	public static List<Integer> bestSumRecursive(int targetSum, List<Integer> numbers) {
		if (targetSum == 0)
			return new ArrayList<>();
		if (targetSum < 0)
			return null;

		List<Integer> shortestCombination = null;

		for (Integer num : numbers) {
			int remainder = targetSum - num;
			List<Integer> remainderResult = bestSumRecursive(remainder, numbers);
			if (remainderResult != null) {
				List<Integer> combination = new ArrayList<>(remainderResult);
				combination.add(num);
				if (shortestCombination == null || shortestCombination.size() > combination.size()) {
					shortestCombination = combination;
				}
			}
		}
		return shortestCombination;
	}

	// dynamic programming - memoization use list here because arrays are of fixed
	// size and here
	// elements are being added to the remainder result
	// time complexity: targetSum m => up to m different keys in the memo object;
	// branch for every number in the array
	// additional work: n, iterating through for loop, m from copying over this
	// array
	// O(m^2*n)
	// Space complexity: O(m^2)
	public static List<Integer> bestSumMemoization(int targetSum, List<Integer> numbers,
			HashMap<Integer, List<Integer>> memo) {
		if (memo.containsKey(targetSum))
			return memo.get(targetSum);
		if (targetSum == 0)
			return new ArrayList<>();
		if (targetSum < 0)
			return null;

		List<Integer> shortestCombination = null;
		for (Integer num : numbers) {
			int remainder = targetSum - num;
			List<Integer> remainderResult = bestSumMemoization(remainder, numbers, memo);
			if (remainderResult != null) {
				List<Integer> combination = new ArrayList<>(remainderResult);
				combination.add(num);
				if (shortestCombination == null || shortestCombination.size() > combination.size()) {
					shortestCombination = combination;
					memo.put(targetSum, shortestCombination);
				}
			}
		}
		memo.put(targetSum, shortestCombination);
		return shortestCombination;
	}

	public static List<Integer> bestSumMemoization(int targetSum, List<Integer> numbers) {
		HashMap<Integer, List<Integer>> memo = new HashMap<>();
		return bestSumMemoization(targetSum, numbers, memo);
	}

	// dynamic programming - tabulation use list here because arrays are of fixed
	// size and here
	// elements are being added to the remainder result
	// time complexity: targetSum m => up to m different keys in the memo object;
	// branch for every number in the array
	// additional work: n, iterating through for loop, m from copying over this
	// array
	// O(m^2*n)
	// Space complexity: O(m^2)
	public static List<Integer> bestSumTabulation(int targetSum, List<Integer> numbers) {

		List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
		table.set(0, new ArrayList<>());

		for (int i = 0; i <= targetSum; i++) {
			if (table.get(i) != null) {
				for (int num : numbers) {
					if (i + num <= targetSum) {
						List<Integer> combination = new ArrayList<>(table.get(i));
						combination.add(num);
						if (table.get(i + num) == null || table.get(i + num).size() > combination.size()) {
							table.set(i + num, combination);

						}
					}
				}
			}
		}

		return table.get(targetSum);
	}

	

	public static void main(String[] args) {
		int targetSum = 7;
		List<Integer> numbers = new ArrayList();
		numbers.add(5);
		numbers.add(3);
		numbers.add(4);

		List<Integer> numbers2 = new ArrayList();
		numbers2.add(2);
		numbers2.add(2);
		numbers2.add(3);

		int[] nums = { 1, 3, 4, 5 };

		System.out.println((bestSumMemoization(targetSum, numbers)));
		System.out.println((bestSumTabulation(targetSum, numbers)));

//		System.out.println((bestSumRecursive(targetSum, numbers2)));
	}
}
