

public class EuclideanAlgorithm{
	

	public static String division(int a , int b){
		
		int i = 0;
		int ans = 0;
		int r = 0;
		while(ans<=a-b){
			i = i+1;
			ans = ans + b;
			if (ans>=a-b) {
				r = a-ans;
			}
		}
		return "" + i + "," + r;
	}

	public static int gcd(int a , int b){
		if (a>b) {
			int temp = a;
			a=b;
			b=temp;
		}

		String first = division(a,b);
		String[] s;
		s = first.split(",");
		//s[1] = first;
		System.out.println(s[0]);
		System.out.println(s[1]);



		return -1;
	}



	public static void main(String[] args) {
		//System.out.println(division(10,3));
		//gcd(10 , 3);
		String s = "hello";
		s = s.substring(0 , 1);
		System.out.println(s);
	}
}