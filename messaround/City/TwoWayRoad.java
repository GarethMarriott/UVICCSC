
public class TwoWayRoad extends Road{

  public String directionOne;//N = North    S = South   E = East  W = West NEED TWO LETTERS FOR DIR
  public String directiontwo;
  public int lanesOne;
  public int lanesTwo;


  public TwoWayRoad(String dir , int lanes1 , int lanes2){
    directionOne = dir.substring(0,1);
    directiontwo = dir.substring(1,2);
    lanesOne = lanes1;
    lanesTwo = lanes2;
  }

  public String toString(){
    return "" + directionOne + directiontwo + lanesOne + lanesTwo;
  }

  public String getDirection(){
    return directionOne + directiontwo;
  }
}
