package arrayOperations;

import java.util.HashSet;

//can a given sum be formed by 2 pairs of a given array which is unsorted?
public class CanSumFromAPairOfNumsInUnsortedArray {

	
	static boolean canSum(int targetSum, int[] numbers) {
		HashSet<Integer> complements = new HashSet<>();
		for (int n : numbers) {
			if (complements.contains(targetSum-n)) {
				return true;
			}
			complements.add(targetSum-n); //add complement
		}
		return false;
	}
	
	
	
	public static void main(String[]args) {
		int[] arr1 = {1,2,3,4};
		int[]arr2 = {1,2,4,4};
		int targetSum = 8;
		System.out.println(canSum(targetSum, arr1));
	}
}
 