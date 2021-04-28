package simpleArrayOperations;

import java.util.Arrays;

public class FindPairs {
	
	    // Complete the sockMerchant function below.
	    static int sockMerchant(int n, int[] arr) { //how many pairs of equal elements does the input array have?
	    	
	    	// Sort the original array
	        Arrays.sort(arr);
	        int res = 0;
	        int i = 0;
	 
	        while (i < n) {
	             
	            // take first number
	            int number = arr[i];
	            int count = 1;
	            i++;
	 
	            // Count all duplicates
	            while (i < n && arr[i] == number) {
	                count++;
	                i++;
	            }
	             
	            // Count num of times a number has been spotted => divide by 2 to get pairs 
	            // => increment result
	            if (count >= 2) {
	                res = res + count / 2; //divide by 2 cause we want pairs,not unique numbers 
	            }
	        }
	        return res;

	    }
	    
		public static void main(String[] args) {
			int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};
			System.out.println("The number of pairs is: " + sockMerchant(9, arr));
		}

}
