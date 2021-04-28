package arrayOperations;

public class LeftRotationsWithinArray {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {

		int n = a.length;
		
		//Rotate the given array by n times toward left  
        for(int i = 0; i < d; i++){  
            int j, first;  
            //Stores the first element of the array  
            first = a[0];  
            for(j = 0; j < n-1; j++){  
                //Shift element of array by one  
                a[j] = a[j+1];  
            }  
            //First element of array will be added to the end  
            a[j] = first;  
        }  
//        for (int i = 0; i < a.length; i++) {
//			System.out.println("Array post left rotation: " + a[i]);
//		}
		return a;
	}

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int numOfRotations = 4;
		int[] rotatedArr = rotLeft(arr, numOfRotations);
		for (int i = 0; i < rotatedArr.length; i++) {
			System.out.println("Array post left rotation: " + rotatedArr[i]);
		}
	}
}
