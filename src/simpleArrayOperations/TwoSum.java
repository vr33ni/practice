package simpleArrayOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

	static int[] twoSum(int[] nums, int target) {

		if (target == 0)
			return new int[] {};
		if (target < 0)
			return null;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};

	}

	static int[] twoSumHashMap(int[] nums, int target) {

		if (target == 0)
			return new int[] {}; 
		if (target < 0)
			return null;

		HashMap<Integer, Integer> complements = new HashMap<>();
		
		for (int i = 0; i<nums.length; i++) {
			int complement = target - nums[i];
			if (complements.containsKey(complement)) {
				return new int[] {complements.get(complement), i};
			}
			else complements.put(nums[i], i); System.out.println(complements);
		}
		return new int[] {};

	}
	
	public static void main(String[] args) {
		int targetSum = 7;
		

		int[] nums = { 1, 3, 4, 5 };


		System.out.println(Arrays.toString(twoSum(nums, targetSum))); // returning the indices of the numbers making up
																		// the target sum
		System.out.println(Arrays.toString(twoSumHashMap(nums, targetSum)));
	}

}
