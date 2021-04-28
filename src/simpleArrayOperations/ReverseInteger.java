package simpleArrayOperations;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseInteger {

	static int reverse(int x) {
		if (x > Integer.MAX_VALUE)
			return 0;
		if (x < Integer.MIN_VALUE)
			return 0;

		int reversed = 0;

		while (x != 0) {
			int digit = x % 10;
			reversed = reversed * 10 + digit;
			x = x / 10;
		}

		return reversed;
	}

	static int reverseUsingArray(int x) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (x > 0) {
			digits.add(x % 10); // in revsersed order already, but within an arraylist
			x = x / 10;
		}
		int reversed = 0;

		for (int i = 0; i < digits.size(); i++) {
			reversed = reversed * 10 + digits.get(i); //just add them in current order to the int
		}

		return reversed;
	}

	public static void main(String[] args) {
		int x = 1234;
		System.out.println(reverse(x));
		System.out.println(reverseUsingArray(x));
	}

}
