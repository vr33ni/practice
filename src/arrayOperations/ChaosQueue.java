package arrayOperations;

public class ChaosQueue {

	// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
   
    	int n = q.length;
//    	long startTime = System.nanoTime();
    	int bribes = 0;

//    	 another approach
    	  for (int i = 1; i < n; ++i) {
    		  int diff = q[i-1] - (i);
    		  // check if there is an element with a value that differs from its index by more than 2
    		  if (diff > 2) {
    			  System.out.println("Too chaotic");
    			  return;
    		  }
    		  else {
    			  int key = q[i];
                int j = i - 1;
               
                while (j >= 0 && q[j] > key) {
              	  bribes++;             	 
                    q[j + 1] = q[j];
                    j = j - 1;
                }
                q[j + 1] = key;
            }
    	  
    	  }
		  System.out.println(bribes);

//    	  long stopTime = System.nanoTime();
//      	  System.out.println(stopTime - startTime);
      	
      	
//          another approach - modify insertion sort algorithm, instead of swapping unsorted elements, count them as bribes
//      	int bribes = 0;
//    	    boolean bribesPPLargerTwo = false;
//          for (int i = 1; i < n; ++i) {
//              int key = q[i];
//              int j = i - 1;
//             
//              while (j >= 0 && q[j] > key) {
//            	  bribes++;
//            	  if (q[j]-key>2) {
//            		  bribesPPLargerTwo = true;
//            	  }
//                  q[j + 1] = q[j];
//                  j = j - 1;
//              }
//              q[j + 1] = key;
//          }
//    		
//    	if (bribesPPLargerTwo) {
//    	System.out.println("Too chaotic");
//    	System.out.println(bribes);
//    	}
//    	else {
//        	System.out.println(bribes);
//
//    	}
//    	 long stopTime = System.nanoTime();
//       System.out.println(stopTime - startTime);

    }
    
	public static void main(String[] args) {

		int[] arr = { 2, 1, 5, 3, 4 };
		minimumBribes(arr);
		
	}
}
