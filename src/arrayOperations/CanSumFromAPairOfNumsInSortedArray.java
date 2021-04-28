package arrayOperations;


//can a given sum be formed by 2 pairs of a given array which is sorted?
public class CanSumFromAPairOfNumsInSortedArray {

	static boolean canSum(int targetSum, int[] numbers) {
		
		int low = 0;
		int high = numbers.length - 1;
		while (low < high) {
			if (numbers[low] + numbers[high] == targetSum) {
				return true;
			}
			else if (numbers[low] + numbers[high] < targetSum) {
				low++;
				canSum(targetSum, numbers, low, high);
			}
			else if (numbers[low] + numbers[high] > targetSum) {
				high--;
				canSum(targetSum, numbers, low, high);
			}
		}
		return false;		
	}
	
	static boolean canSum(int targetSum, int[] numbers, int low, int high) {
		while (low < high) {
			if (numbers[low] + numbers[high] == targetSum) {
				return true;
			}
			else if (numbers[low] + numbers[high] < targetSum) {
				low++;
				canSum(targetSum, numbers, low, high);
			}
			else if (numbers[low] + numbers[high] > targetSum) {
				high--;
				canSum(targetSum, numbers, low, high);
			}
		}
		return false;		
	}
	
	
	
	public static void main(String[]args) {
		int[] arr1 = {1,2,3,4};
		int[]arr2 = {1,2,4,4};
		int targetSum = 8;
		System.out.println(canSum(targetSum, arr2));
	}
}
 