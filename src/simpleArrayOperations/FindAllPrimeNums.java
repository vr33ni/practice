package simpleArrayOperations;

public class FindAllPrimeNums {

	static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
  
        // Check from 2 to n-1
        for (int i = 2; i < n; i++) // check if can be divided by anything else than 1 or itself (n)
            if (n % i == 0)
                return false;
  
        return true;
    }
	
	static void getPrimeNums(int[] inputArr) {
		
		 for(int i=0; i<inputArr.length; i++){
			 if (isPrime(inputArr[i])) {
				 System.out.println("prime: " + inputArr[i]);
			 }
		 }
	
	}
	
	public static void main(String[] args) {
		int[] arr = {1,4, 7, 11, 31,15,56,46};
		getPrimeNums(arr);
	}
}
