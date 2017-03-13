

public class Map{
	
	public int[][] map;

	public Map(String raw , int width , int height){
		map = new int[width][height];

		for (int i = 0; i < width; i++) {
			for (int k = 0; k< height; k++) {
				map[i][k] = Integer.parseInt(raw.substring(0 , 1));
				raw = raw.substring(1);
			}
		}
	}

	public String toString(){
		String str = "";
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map[0].length; k++) {
				str = str + Integer.toString(map[i][k]);
			}
			str = str + "\n";
		}
		return str;

	}



}