package simpleArrayOperations;

public class JumpingCloundsCountingOperations {

	// Complete the jumpingOnClouds function below.
	static int jumpingOnClouds(int[] c) {
		int counter = 0;
		for (int i = 0; i < c.length-1; i++) {
			if (i+2 < c.length && c[i+2] == 0) {
				i=i+2;
				counter++;

			}
			else {
				counter++;
				i++;
			}
		}
		return counter;

	}

	public static void main(String[] args) {
		int inputArr[] = { 0, 0, 1, 0, 0 ,1, 0};

		System.out.println("the number of jumps is: " + jumpingOnClouds(inputArr));
	}
}
