package simpleArrayOperations;

public class CountingValleysCumulation {

	public static int countingValleys(int steps, String path) {
		// map
		char[] pathToChar = path.toCharArray();
		int[] stepsMapped = new int[steps];
		int k = 0;
//		System.out.println("steps mapped: ");
			for (int j = 0 ; j < steps; j++) {
				String s = Character.toString(pathToChar[j]);

				if (s.equals("U")) {
					stepsMapped[k] = 1;
					k++;
				}
				else if (s.equals("D")) {
					stepsMapped[k] = -1;
					k++;
				}
//				System.out.print(stepsMapped[j] + " ");

			}

	
		int[] valleys = new int[stepsMapped.length];
		valleys[0] = stepsMapped[0];
		int valleyCounter = 0;

		if (stepsMapped[0] < 0 ) { // check if the first step is already representing a valley
			valleyCounter++; // if it is, update valleycounter
		}
//		System.out.println("\ncumulated: ");
		for (int i = 1; i < stepsMapped.length; i++) { // loop through the cumulated array and look for the sequence 0 -1
			valleys[i] = valleys[i - 1] + stepsMapped[i];
//			System.out.print(valleys[i] + " ");

		}
		for (int i = 0; i < valleys.length - 1; i++) {
			if (valleys[i] == 0 && valleys[i + 1] == -1) {
				valleyCounter++;
			}

		}

		return valleyCounter;
	}

	public static void main(String[] args) {
		String steps = "DDUUDDUDUUUD";
		System.out.println("\nvalleys: " + countingValleys(12, steps));
	}
}
