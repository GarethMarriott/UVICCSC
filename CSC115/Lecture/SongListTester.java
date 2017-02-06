class SongListTester
{
	public static void main (String[] args)
	{
		Song a = new Song("first", "song");
		Song b = new Song("second", "also a song");
		Song c = new Song("third", "another song");

		SongList l = new SongList();

		System.out.println("l.size() is:" + l.size());
		System.out.println("l is: " + l );

		l.add(a);
		l.add(b);
		l.add(c);

		System.out.println("l.size() is:" + l.size());
		System.out.println("l is: " + l );				
	}
}

