package dynamicProg;

public class FibNum {

	//recursive => for large n it is pretty slow => memoization to make it linear
	static int nthFibNum(int n) {
		if (n <= 2) {
			return 1;
		}
		return nthFibNum(n-1) + nthFibNum(n-2);		
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
		
		System.out.print("The " + n + nEnding + " fibonacchi number is: " + nthFibNum(n));
	}
}
