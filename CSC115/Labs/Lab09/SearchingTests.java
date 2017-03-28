import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class SearchingTests {

	private static final String border = "*****************************************";
	ArrayList<Integer> list;

	 void primeList(int numElements) {
		Random r = new Random();
		list = new ArrayList<Integer>(numElements);
		for (int i=0; i<numElements; i++) {
			list.add(r.nextInt(numElements));
		}
		Collections.sort(list);
	}

	// Search for the target.
	// return the number of comparisons done.
	int linearSearch(Integer target) {
		int search = 0;
		while (search != list.size()-1) {
			if (target.equals(list.get(search))) {
				return search;
			}
			else{
				search++;
			}
		}
		return search;
	}


	// Search for the target
	// return the number of comparisons done.
	int binarySearch(Integer target) {
		int searches = doBinarySearch(target , 0 , list.size()-1);
		return searches;
	}

	private int doBinarySearch(Integer target , int start , int end){

		if (end-start == 0) {
			return 0;
		}
		if (end-start == 1) {
			return 1;
		}
		int middle = (start + end)/2;
		int compare = target.compareTo(list.get(middle));

		if (compare == 0) {
			return 1;
		}
		else if (compare < 0) {
			return 1 + doBinarySearch(target,start,middle-1);
		}
		else {
			return 1 + doBinarySearch(target,middle+1,end);
		}
	}




	// sample test.
	public static void main(String[] args) {
		int numElements = 100;
		int numTests = 10;

		SearchingTests test = new SearchingTests();
		test.primeList(numElements);
		Random rand = new Random();
		long linearSearchTotal = 0;
		long binarySearchTotal = 0;
		int target;
		for (int i=0; i<numTests; i++) {
			target = rand.nextInt(numElements);
			linearSearchTotal += test.linearSearch(target);
			binarySearchTotal += test.binarySearch(target);
		}
		System.out.println(border);
		System.out.println("Average number of comparisions for list of size "+numElements+":");
		System.out.printf("%-10s%-10s%-10s\n","Tests","Linear","Binary");
		System.out.printf("%-10s%-10s%-10s\n",numTests,linearSearchTotal/numTests,binarySearchTotal/numTests);
	}
}
