package dynamicProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HowSum {

	// recursive approach
	public static List<Integer> howSumRecursive(int targetSum, List<Integer> numbers) {
		if (targetSum == 0)
			return new ArrayList<>();
		if (targetSum < 0)
			return null;

		for (Integer num : numbers) {
			int remainder = targetSum - num;
			List<Integer> remainderResult = howSumRecursive(remainder, numbers);
			if (remainderResult != null) {
				remainderResult.add(num);
				return remainderResult;
			}
		}
		return null;
	}

	// dynamic programming - memoization use list here because arrays are of fixed
	// size and here
	// elements are being added to the remainder result
	public static List<Integer> howSumMemoization(int targetSum, List<Integer> numbers,
			HashMap<Integer, List<Integer>> memo) {
		if (memo.containsKey(targetSum))
			return memo.get(targetSum);
		if (targetSum == 0)
			return new ArrayList<>();
		if (targetSum < 0)
			return null;

		for (Integer num : numbers) {
			int remainder = targetSum - num;
			List<Integer> remainderResult = howSumMemoization(remainder, numbers, memo);
			if (remainderResult != null) {
				remainderResult.add(num);
				memo.put(targetSum, remainderResult);
				return remainderResult;
			}
		}
		memo.put(targetSum, null);
		return null;
	}

	public static List<Integer> howSumMemoization(int targetSum, List<Integer> numbers) {
		HashMap<Integer, List<Integer>> memo = new HashMap<>();
		return howSumMemoization(targetSum, numbers, memo);
	}

	// dynamic programming - tabulation - use list here because arrays are of fixed
	// size and here
	// elements are being added to the remainder result
	public static List<Integer> howSumTabulation(int targetSum, List<Integer> numbers) {
		List<List<Integer>> table = new ArrayList<>(Collections.nCopies(targetSum + 1, null));
	
		table.set(0, new ArrayList<>());

		for (int i = 0; i <= targetSum; i++) {
			if (table.get(i) != null) {
				for (int num : numbers) {
					if (i + num <= targetSum) {
						// the following will not create a deep copy, just a shallow copy, copy of the references of the original array
						table.set(i + num, new ArrayList<>(table.get(i))); //adding the value from the current index i
						table.get(i + num).add(num); //adding current number (=how far we were looking ahead)
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
		numbers2.add(6);
		numbers2.add(6);
		numbers2.add(3);

//		System.out.println((howSumRecursive(targetSum, numbers)));
//		System.out.println((howSumMemoization(targetSum, numbers)));

		System.out.println((howSumTabulation(targetSum, numbers)));

	}

}
