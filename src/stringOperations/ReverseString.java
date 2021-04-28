package stringOperations;

public class ReverseString {

	public static String FirstReverse(String str) {

		String reversed = "";

		// for loop
//	    char[] chars = str.toCharArray(); 
//	    for (int i = chars.length-1; i>= 0 ;i--) {
//	    	reversed = reversed + chars[i];
//	    }
		
		// stringbuilder
		 if (str == null) {
		        return null;
		    }
		StringBuilder output = new StringBuilder(str).reverse();
		reversed = output.toString();

		return reversed;
	}
	
	//another stringbuilder approach
	public static String reverseUsingSB(String reverse) {
			
			if (reverse.length() < 2) {
				return reverse;
			}
			
			char[] arr = reverse.toCharArray();
			StringBuilder sb = new StringBuilder();
			
			for (int i=arr.length-1; i>=0;i--) {
				sb.append(arr[i]);
			}
			return new String(sb.toString());
		
	}

	public static void main(String[] args) {
		// keep this function call here
		String s = "I Love Coding";
		System.out.print(FirstReverse(s));
	}

}
