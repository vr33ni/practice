package simpleArrayOperations;

import java.util.Arrays;

public class FindNumberPairsWithDifferenceK {

	// Standard binary search function //
	static int binarySearch(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (x == arr[mid])
				return mid;
			if (x > arr[mid])
				return binarySearch(arr, (mid + 1), high, x);
			else
				return binarySearch(arr, low, (mid - 1), x);
		}
		return -1;
	}

	static int pairsWithDifferenceK(int[] arr, int k) {
		int count = 0;
		int n = arr.length;

		// BINARY SEARCH
		Arrays.sort(arr);
		for (int i = 0; i < n - 1; i++) {
			if (binarySearch(arr, i + 1, n - 1, arr[i] + k) != -1) {
				count++;
			}

		}

//		 // BRUTE FORCE Pick all elements one by one
//        for (int i = 0; i < n; i++)
//        {
//            // See if there is a pair
//            // of this picked element
//            for (int j = i + 1; j < n; j++)
//                if (Math.abs(arr[i]-arr[j])==k)
//                    count++;
//        }

		return count;

	}

	public static void main(String[] args) {
		int[] arr = { 1, 7, 5, 9, 2, 12, 3 };
		int k = 2;
		System.out.println(pairsWithDifferenceK(arr, k));
	}
}
