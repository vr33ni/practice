package arrayOperations;

//Input: new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}
//Output: 1,4,13 => overlap
public class FindIntersectionOfElements {
	public static String FindIntersection(String[] strArr) {
		// code goes here
		String e1 = strArr[0];
		String e2 = strArr[1];
		String[] convertedE1 = e1.split(", ");
		String[] convertedE2 = e2.split(", ");

		String overlappingE = "";

		for (int i = 0; i < convertedE1.length; i++) {
			for (int j = 0; j < convertedE2.length; j++) {

				if (convertedE1[i].equals(convertedE2[j])) {
					if (overlappingE == "") {
						overlappingE = overlappingE + convertedE1[i];
					} else {
						overlappingE = overlappingE + "," + convertedE1[i];
					}
				} 

			}
		}
		if (overlappingE == "") {
			overlappingE = "false";
		}

		return overlappingE;
	}

	public static void main(String[] args) {
		// keep this function call here
		String[] s = { "1, 3, 4, 7, 13", "1, 2, 4, 13, 15" };
		System.out.print(FindIntersection(s));
	}
}
