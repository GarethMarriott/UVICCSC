
public class TwoWayRoad extends Road{

  public int direction;//1 = up and down        2 = left and right
  public int lanesUpOrLeft;
  public int lanesDownOrRight;


  public TwoWayRoad(int dir){
    direction = dir;
  }
}
