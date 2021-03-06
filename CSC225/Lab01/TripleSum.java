/* TripleSum.java
   CSC 225 - Summer 2017
   Lab 1 - Template for the TripleSum problem

   This template includes some testing code to help verify the implementation.
   To interactively provide test inputs, run the program with
	java TripleSum

   To conveniently test the algorithm with a large input, create a
   text file containing space-separated integer values and run the program with
	java TripleSum file.txt
   where file.txt is replaced by the name of the text file.

   B. Bird - 05/06/2017
*/

import java.util.Scanner;
import java.util.LinkedList;
import java.io.File;
import java.util.Arrays;

public class TripleSum{
	/* TripleSum225()
		The input array A will contain non-negative integers. This method
		will search the input array A for three elements which sum to 225.
		If such a triple is found, return true. Otherwise, return false.
		The triple may contain the same element more than once.
		The function may modify the array A.
	*/
	public static boolean TripleSum225(int[] A){


    int[] B = new int[226];

    for (int i = 0; i<A.length; i++) {
      if (A[i]<=225) {
        int targ = A[i];
        B[targ]=1;
      }
    }

    for (int i = 0; i<226; i++) {
      for (int j = 0; j<226; j++) {
        for (int k = 0; k<226; k++) {
          if ((B[i]==1)&&(B[j]==1)&&(B[k]==1)&&((i+j+k)==225)) {
            return true;
          }
        }
      }
    }
    return false;








    // Arrays.sort(A);
    // for (int i = 0; i<A.length; i++) {
    //   for (int j = 0; j<A.length; j++) {
    //     int k = 225 - (A[i]+A[j]);
    //     if(0<=Arrays.binarySearch(A,k)){
    //       return true;
    //     }
    //   }
    // }
    // return false;





		// for (int i = 0; i<A.length; i++) {
		//   for (int j = 0; j<A.length; j++) {
		//     for (int l = 0; l<A.length; l++) {
    //       if ((A[i]+A[j]+A[l])==225) {
    //         return true;
    //       }
		//     }
		//   }
		// }
    // return false;

	}

	/* main()
	   Contains code to test the TripleSum225 function.
	*/
	public static void main(String[] args){
		Scanner s;
		if (args.length > 0){
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
			s = new Scanner(System.in);
			System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
		}

		LinkedList<Integer> inputList  = new LinkedList<Integer>();
		int v;
		while(s.hasNextInt() && (v = s.nextInt()) >= 0)
			inputList.addLast(v);


		//For convenience, convert the LinkedList into a regular array.
		//Note that we can find the size of a LinkedList in O(1) time
		//(according to the Java documentation).

		int[] array = new int[inputList.size()];

		int idx = 0;
		for(int element: inputList){
			array[idx] = element;
			idx++;
		}


		System.out.printf("Read %d values.\n",array.length);


		long startTime = System.currentTimeMillis();

		boolean tripleExists = TripleSum225(array);

		long endTime = System.currentTimeMillis();

		double totalTimeSeconds = (endTime-startTime)/1000.0;

		System.out.printf("Array %s a triple of values which add to 225.\n",tripleExists? "contains":"does not contain");
		System.out.printf("Total Time (seconds): %.2f\n",totalTimeSeconds);
	}
}
