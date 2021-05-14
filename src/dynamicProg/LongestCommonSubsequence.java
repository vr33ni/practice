package dynamicProg;

import java.util.Arrays;

public class LongestCommonSubsequence {

	// recusive solution: O(2^n) time
	public static int lcsLengthRecursive(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		return lcsLengthRecursive(s1, s2, n, m);

	}

	// recusive solution: O(2^n) time
	public static int lcsLengthRecursive(String s1, String s2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			return 1 + lcsLengthRecursive(s1, s2, n - 1, m - 1);
		} else
			return Math.max(lcsLengthRecursive(s1, s2, n, m - 1), lcsLengthRecursive(s1, s2, n - 1, m));

	}

	// dp - memoization: O(nm) time
	public static int lcsLengthDPMemoization(String s1, String s2) {
		// Write your code here

		int s1Len = s1.length();
		int s2Len = s2.length();

		return lcsLengthDPMemoization(s1, s2, s1Len, s2Len);

	}

	// top down approach - break problem down into sub problems and then calculate +
	// store the values
	public static int lcsLengthDPMemoization(String s1, String s2, int n, int m) {
		int max = Math.max(n, m);
		// Use a 2-D array to store the computed lcs(m, n) value at arr[m-1][n-1] as the
		// string index starts from 0.
		int dp[][] = new int[max][max];

		// assign -1 to all positions
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return lcsLengthDPMemoization(s1, s2, n, m, dp);
	}

	public static int lcsLengthDPMemoization(String s1, String s2, int n, int m, int dp[][]) {

		if (n == 0 || m == 0) {
			return 0;
		}

		// if the same state has already been computed
		if (dp[m - 1][n - 1] != -1) {
			return dp[m - 1][n - 1];
		}
		// Whenever the function with the same argument m and n are called again, do not
		// perform any further recursive call and return arr[m-1][n-1] as the previous
		// computation of the lcs(m, n) has already been stored in arr[m-1][n-1], hence
		// reducing the recursive calls that happen more than once.
		// if equal, then we store the value of the function call
		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			dp[m - 1][n - 1] = 1 + lcsLengthDPMemoization(s1, s2, n - 1, m - 1, dp);
			return dp[m - 1][n - 1];

		}
		// store it in arr to avoid further repetitive
		// work in future function calls
		else
			dp[m - 1][n - 1] = Math.max(lcsLengthDPMemoization(s1, s2, n, m - 1, dp),
					lcsLengthDPMemoization(s1, s2, n - 1, m, dp));

		return dp[m - 1][n - 1];
	}

	// bottom up approach, calculating smaller values first tbl[i][j] and building
	// larger values from them
	public static int lcsLengthDPTabulation(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();

		// lookup table stores solution to already computed subproblems,
		// i.e., `T[i][j]` stores the length of LCS of substring
		// `X[0…i-1]` and `Y[0…j-1]`
		int[][] tbl = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// if the current character of `s1` and `s2` matches
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					tbl[i][j] = tbl[i - 1][j - 1] + 1;
				} else
					tbl[i][j] = Math.max(tbl[i - 1][j], tbl[i][j - 1]);
			}
		}
		return tbl[n][m];

	}
	
	public static String lcsPrintUsingTabulation(String s1, String s2, int n, int m) {
		
		int[][]tbl = new int[n+1][m+1];
		for (int i=1; i<=n;i++) {
			for (int j=1; j<=m;j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					tbl[i][j] = tbl[i-1][j-1] + 1;
				}
				else tbl[i][j] = Math.max(tbl[i-1][j], tbl[i][j-1]);
			}
		}
		
		int index = tbl[n][m];
		int temp = index;
		
		char[] lcs = new char[index+1];
		lcs[index] = '\u0000'; //las character null
		
		
		int i=n;
		int j=m;
		
		while (i>0 && j>0) {
			if (s1.charAt(i-1) == s2.charAt(j-1)) {
				lcs[index-1] = s1.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if (tbl[i-1][j] > tbl[i][j-1]) {
				i--;
			} else j--;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int k=0; k<temp; k++) {
			sb.append(lcs[k]);
//			System.out.println(lcs[k]);
		}
		
		return sb.toString();
	}

	
	public static int ways(int num) { 
		//10 5 - 4 - 2 - 1
		//10 9 - 3 - 2/1
		//10 - 
		int count = 0;
		
		if (num==0) return 0;
		while (num>1) {
			if (num%3 == 1) {
				num=num-1;
				count++;
				continue;
			}
			else if (num%3==0) {
				num=num/3;
				count++;
				continue;

			}
			else if (num%2==0) {
				num=num/2;
				count++;
				continue;

			}
			else {
				num=num-1; 
				count++;
				continue;

			}
				
		}
		return count;
		
		 
	}
	
	public static void main(String[] args) {

		String s1 = "ABCABEXVB";
		String s2 = "BCACDBV";
		System.out.println(lcsLengthDPMemoization(s1, s2));
		System.out.println(lcsLengthDPTabulation(s1, s2));
		System.out.println(lcsLengthRecursive(s1, s2));
		System.out.println(lcsPrintUsingTabulation(s1, s2, s1.length(), s2.length()));
		System.out.println(ways(11));

	}
}
