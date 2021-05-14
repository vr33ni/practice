package dynamicProg;

import java.util.HashMap;

public class FibNum {

	//recursive => for large n it is pretty slow => memoization to make it linear
	static int nthFibNum(int n) {
		if (n <= 2) {
			return 1;
		}
		return nthFibNum(n-1) + nthFibNum(n-2);		
	}
	
	//memoization 
	static int nthFibNumMemoization(int n) {
		HashMap<Integer, Integer> memo = new HashMap<>();
		return nthFibNumMemoization(n, memo);		
	}
	
	//memoization 
	static int nthFibNumMemoization(int n, HashMap<Integer, Integer> memo) { 
		if (n <= 2) {
			return 1;
		}
		return nthFibNum(n-1) + nthFibNum(n-2);		
	}
	
	//tabultion
	static int nthFibNumTabulation(int n) {
		if (n <= 2) {
			return 1;
		}
		
		int[]table = new int[n+1];
		table[0] = 0;
		table[1] = 1;

		for (int i = 2; i<=n; i++) {
			if (table[i] == 0) {
				table[i] = table[i-1] + table[i-2];
			}
		}
		
		return table[n];		
	}
	
	
	
	static boolean isFib(int n) {
		if (n <= 1) {
			return false;
		}
		else return isPerfectSquare(5 * n*n +4) || isPerfectSquare(5*n*n-4);	
	}
	
    static boolean isPerfectSquare(int x)
    {
        int s = (int)Math.sqrt(x);
        return (s * s == x);
    }
	
	
	
	public static void main(String[]args) {
		int n = 7;
		String nEnding = "";
		if (n == 1) {
			nEnding = "st";
		}
		else if (n==2) {
			nEnding = "nd";
			
		}
		else if (n==3) {
			nEnding = "rd";
		}
		else nEnding = "th";
		
//		System.out.print("Fib Recursive: The " + n + nEnding + " fibonacchi number is: " + nthFibNum(n));
		System.out.print("Fib tabulation: The " + n + nEnding + " fibonacchi number is: " + nthFibNumTabulation(n));

	}
}
