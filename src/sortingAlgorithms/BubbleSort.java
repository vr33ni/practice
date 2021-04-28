package sortingAlgorithms;

public class BubbleSort {

	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		 for(int i=0; i < n-1; i++){  
             for(int j=0; j < n-i-1; j++){  
                 if(arr[j] > arr[j+1]){  
                        //swap elements  
                        int temp = arr[j];  
                        arr[j] = arr[j+1];  
                        arr[j+1] = temp;  
                 }
             }
		}
	}

	public static void printArray(int arr[]) {
		 int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	}
	
	


	// Main function
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		System.out.println("Unsorted Array");
		printArray(arr);

		System.out.println("\nSorted array");
		bubbleSort(arr);
		printArray(arr);
	}
}
