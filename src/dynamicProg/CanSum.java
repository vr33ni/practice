package dynamicProg;

import java.util.HashMap;

//Can the targetSum be formed with any combination of the given numbers?
public class CanSum {

	//brute force recursive solution
	static boolean canSumRecursive(int targetSum, int[] numbers) {
		if (targetSum == 0)
			return true;
		if (targetSum < 0)
			return false;

		for (Integer num : numbers) {
			int remainder = targetSum - num;
			if (canSumRecursive(remainder, numbers))
				return true;
		}
		return false;
	}

	// more efficient, dynamic programming solution - memoization
	static boolean canSumDynamicProgrammingMemoization(int targetSum, int[] numbers) {
		HashMap<Integer, Boolean> memo = new HashMap<>();
		return canSumDynamicProgrammingMemoization(targetSum, numbers, memo);
	}

	static boolean canSumDynamicProgrammingMemoization(int targetSum, int[] numbers, HashMap<Integer, Boolean> memo) {
		if (memo.containsKey(targetSum)) return memo.get(targetSum);
		if (targetSum == 0)
			return true;
		if (targetSum < 0)
			return false;

		for (Integer num : numbers) {
			int remainder = targetSum - num;
			if (canSumDynamicProgrammingMemoization(remainder, numbers, memo)) {
				memo.put(targetSum, true);
				return true;
			}
		}
		memo.put(targetSum, false);
		return false;
	}
	
	// more efficient, dynamic programming solution - tabulation
	static boolean canSumDynamicProgrammingTabulation(int targetSum, int[] numbers) {
		boolean[] table = new boolean[targetSum+1]; //+1 to represent information about the case of the targetSum being 0
		table[0] = true; // seed value base case construction
		
		for (int i=0; i<=targetSum; i++) { //iterate over the table
			if (table[i] == true) { // if the element at index i of the table is true, that means the element at this position can be constructed by the elements from our numbers array
				for (int num : numbers) { 
					if (i+num<=targetSum) { //check if we are still within the bounds of our array
						table[i+num] = true; //jump to the position num elements ahead of i and also set to true
					}
				}
			}
		}
		
		return table[targetSum];
	}


	public static void main(String[] args) {
		int targetSum = 11;
		int[] numbers = { 2, 3, 4 };

		long start = System.nanoTime();

//		System.out.println(canSumRecursive(targetSum, numbers));
		System.out.println(canSumDynamicProgrammingMemoization(targetSum, numbers));
		System.out.println(canSumDynamicProgrammingTabulation(targetSum, numbers));

		long end = System.nanoTime();
		long duration = end - start;
		System.out.println("Method execution time: " + duration);

	}
}
