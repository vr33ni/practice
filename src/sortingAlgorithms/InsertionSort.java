package sortingAlgorithms;

//1: Iterate from arr[1] to arr[n] over the array. 
//2: Compare the current element (key) to its predecessor. 
//3: If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
public class InsertionSort {

	public static void insertionSort(int arr[]) {
		int n = arr.length;
		for (int i=1; i<n; i++) {
			int key=arr[i];
			int j = i-1;
			
			while(j>=0 && arr[j]>key) {
				//move the elements greater than the key one position ahead of their original position
				arr[j+1] = arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}

	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 4, 5, 6, 1, 9, 2 };
		System.out.println("Unsorted array: ");
		printArray(arr);
		insertionSort(arr);
		System.out.println("Sorted array: ");
		printArray(arr);
	}
}
