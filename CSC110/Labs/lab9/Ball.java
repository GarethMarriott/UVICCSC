/*
Gareth Marriott
v00875748
*/

import java.awt.*;

class Ball{

  private Color color;
  private Point point;
  private int radius;

  public Ball(int x , int y , int radius , Color colour){
    this.radius = radius;
    this.color = colour;
    Point p1 = new Point(x,y);
    this.point = p1;
  }

  public void setColour(Color colour){
    this.color = colour;
  }
  public Color getColour(){
    return this.color;
  }

  public void setRadius(int radius){
    this.radius=radius;
  }

  public int getRadius(){
    return this.radius;
  }

  public Point getPoint(){
    return this.point;
  }

  public void move(int dx , int dy){
    this.point.translate(dx,dy);
  }
}
