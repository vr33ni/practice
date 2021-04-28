package arrayOperations;

public class RotateMatrix {

	// clockwise rotation
	static boolean rotate(int[][] matrix) {

		if (matrix.length == 0) {
			return false;
		}
		// define the number of cycles (1st row, last col, last row, first col) a matrix
		// has - a 3x3 matrix only has one
		// traverse each cycle
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) { // n/ 2 =  number of cycles (outer rows first, then inner)
			for (int j = i; j < n - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i]; // top left corner gets replaced by bottom left corner
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // bottom left corner gets replace by bottom right
																		// one
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // bottom right gets replaced by top right
				matrix[j][n - 1 - i] = temp; // top right gets replaced by top left
			}
		}
		return true;
	}

	// counter-clockwise rotation
	static boolean rotateCounterClockwise(int[][] matrix) {

		if (matrix.length == 0) {
			return false;
		}
		// define the number of cycles (1st row, last col, last row, first col) a matrix
		// has - a 3x3 matrix only has one
		// traverse each cycle
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][n - 1 - i]; // top left corner gets replaced by top right
				matrix[n - 1 - j][i] = temp; // bottom left corner gets replace by top left
				matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i]; // bottom right gets replaced by bottom left
				matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j]; // top right gets replaced by bottom right
			}
		}
		return true;
	}

	// 180degrees rotation
	static boolean rotate180Degrees(int[][] matrix) {

		int n = matrix.length;
		if (matrix.length == 0) {
			return false;
		}
		 int rows = matrix.length;
	      int cols = matrix[0].length;

	      if (rows % 2 != 0) {
	            //If N is odd reverse the middle row in the matrix
	            reverseRow(matrix, matrix.length / 2);
	        }
	    //Swap the value of matrix [i][j] with [rows - i - 1][cols - j - 1] for half the rows size.
	        for (int i = 0; i <= (rows/2) - 1; i++) {
	            for (int j = 0; j < cols; j++) {
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[rows - i - 1][cols - j - 1];
	                matrix[rows - i - 1][cols - j - 1] = temp;
	            }
	        }

		return true;
	}
	      
	      private static void reverseRow(int[][] data, int index) {
	          int cols = data[index].length;
	          for (int i = 0; i < cols / 2; i++) {
	              int temp = data[index][i];
	              data[index][i] = data[index][cols - i - 1];
	              data[index][cols - i - 1] = temp;
	          }
	      }

	      
	    static  int [][] rotateNM(int [][] input){

	    	  int n =input.length;
	    	  int m = input[0].length;
	    	  int [][] output = new int [m][n];

	    	  for (int i=0; i<n; i++)
	    	  	for (int j=0;j<m; j++)
	    	  		output [j][n-1-i] = input[i][j];
	    	  return output;
	    	  }
	      
	public static void main(String[] args) {
		int n = 5;
		int m = 6;
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = i * n + j + 1; // matrix will start from 1 and go till 25
			}
		}
		int[][] b = new int[n][m];
		   for (int i = 0; i < b.length; i++) {
	            for (int j = 0; j < b[i].length; j++) {
	                b[i][j] = i + j;
	            }
	        }
		   
//		rotate(a);
		rotateNM(b);
//		rotate180Degrees(a);
//		

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}
}
