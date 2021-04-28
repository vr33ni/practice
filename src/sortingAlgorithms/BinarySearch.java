package sortingAlgorithms;

public class BinarySearch {
	
	//can also be used to search sorted String arrays, eg [{"alex", "berta", "david"}]
	public static int binarySearchRecursively(int[] sortedArray, int key, int low, int high) {
		int mid = (low + high) / 2;
		if (high < low) {
			return -1;
		}
		if (key == sortedArray[mid]) {
			System.out.println("Searched for term found at index: " + mid);
			return mid;
		}
		else if (key < sortedArray[mid]) {
			return binarySearchRecursively(sortedArray, key, low, mid - 1);
		}
		else {
			return binarySearchRecursively(sortedArray, key, mid+1, high);
		}
	}
	public static void main (String args[]) {
		int[] sortedArr = {1,2,3,4,5};
		int searchFor = 3;
		binarySearchRecursively(sortedArr,searchFor,1,5);
	}

}
