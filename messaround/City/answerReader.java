

public class answerReader{
	
	public answerReader(){

	}

	public static void main(String[] args) {
		int i = Integer.parseInt(args[1]);
		int j = Integer.parseInt(args[2]);

		Map map = new Map(args[0] , i , j);

		System.out.println(map);
	}
}