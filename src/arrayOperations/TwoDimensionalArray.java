package arrayOperations;

public class TwoDimensionalArray {
	
	//num of rows + cols
	static int R = 6; 
	static int C = 6;
	
	// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	 if (R < 4 || C < 4)
    	        return -1;
    	 
    	int max_sum = Integer.MIN_VALUE; //value can be negative (constraints -9 up to 9)
    	for (int i = 0; i < R-2; i++ ) {
    		for (int j=0; j< C-2;j++) {
    			int sum = (arr[i][j] + arr[i][j+1]+arr[i][j+2])+
    					(arr[i+1][j+1])+
    					(arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]);
    			if (sum > max_sum) {
    				max_sum=sum;
    			}
    		}
    	}
    	return max_sum;

    }

    
	public static void main(String[] args) {
		int[][] arr = { 
				{1, 1, 1, 0, 0, 0},
				{0, 1, 0, 0, 0, 0},
				{1, 1, 1, 0, 0, 0},
				{0, 0, 2, 4, 4, 0},
				{0, 0, 0, 2, 0, 0},
				{0, 0, 1, 2, 4, 0},
			   };
		System.out.println("The highest hourglass sum is: " + hourglassSum(arr));
	}
}
