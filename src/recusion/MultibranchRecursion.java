package recusion;

public class MultibranchRecursion {

	//O(2^n) time (2 recursive calls) 2^n nodes
	//O(n) space
	static int nthFib(int n) {
			if (n == 1 || n == 2) return 1;
			return nthFib(n-1) + nthFib(n-2);
		}


		public static void main(String[] args) {
			int n = 4;
			String rev = "b";
			System.out.println(nthFib(n));
		}
	}
