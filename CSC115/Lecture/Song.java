class Song
{
	// Constructor
	public Song (String t, String a)
	{
		title = t;
		artist = a;
		album = new String("none specified");
		currentRank = 0;
		lastWeekRank = 0;
	}
	public Song (String t, String a, String al)
	{
		title = t;
		artist = a;
		album = al;
		currentRank = 0;
		lastWeekRank = 0;
	}

	public void setTitle (String newtitle)
	{
		title = newtitle;
	}

	public void setArtist (String newartist)
	{
		artist = newartist;
	}

	public void setAlbum (String newalbum)
	{
		album = newalbum;
	}
	
	public String getTitle ()
	{
		return title;
	}

	public String getArtist()
	{
		return artist;
	}

	public String getAlbum()
	{
		return album;
	}

	public boolean equals (Song other)
	{
		// title and artist are of type String
		// 
		// Since String is an object, we must use the .equals method
		// to compare them.
		//
		// Note that we are invoking the String .equals method here, this
		// is not a recursive call to the Song .equals method.
		return title.equals(other.title) && artist.equals(other.artist);

	}

	// This method is special in Java.  If you use an object reference
	// anywhere a String might be expected, the runtime system will 
	// automatically call this method.
	//
	// For example:
	//
	// Song s = new Song("abc", "def");
	//
	// System.out.println(s); 
	//
	// In this case, what is actually happening is:
	//
	// System.out.println(s.toString());
	//
	public String toString()
	{
		// You should really use StringBuffer here, but...
		return "["+artist+","+title+","+album+"]";
	}

	// attributes
	private String	title;
	private String	artist;

	private String album;

	private int	currentRank;
	private int	lastWeekRank;
	private int	weeksOnChart;
	private int	highestRank;
}

