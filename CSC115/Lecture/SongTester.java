class SongTester
{

	public static void main (String[] args)
	{
		int x = 7;
		int y = 7;

		if (x == y)
			System.out.println("x == y");	

		// Notice that these are the same song
		Song s = new Song("abc", "def");
		Song q = new Song("abc", "def");


		// This is not true.  s and q do not point to the
		// same object

		if (s == q)
			System.out.println("s == q");
	
		//
		// However, I've decided that two songs with the
		// same artist and title are equivalent songs,
		// so the .equals method in Song will return true
		// for this comparison
		// q.equals(s) is equivalent
		System.out.println(s);
		System.out.println(q);
		if (s.equals(q))
			System.out.println("they are the same song");
	}
}
