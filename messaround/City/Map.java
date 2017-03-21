

public class Map{

	public Tile[][] map;

	public Map(String raw , int width , int height){
		map = new Tile[width][height];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j< height; j++) {
				int rawIn = Integer.parseInt(raw.substring(0 , 1));
				raw = raw.substring(1);
				if (rawIn == 0) {
					map[i][j] = new NotRoad();
				}else if (rawIn == 1) {
					map[i][j] = new TwoWayRoad("NS" , 2 , 2);
				}else if (rawIn == 2) {
					map[i][j] = new StopLight();
				}else {
					map[i][j] = new Tile();
				}
			}
		}
	}

	public String toString(){
		String str = "";
		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map[0].length; k++) {
				str = str + map[i][k].toString();
			}
			str = str + "\n";
		}
		return str;

	}



}
