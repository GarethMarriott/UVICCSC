Copyright (c) 2017 Copyright Holder All Rights Reserved.

public class Tracks{

  private final double distance = 4000.0;
  //private String carName;
  private double averageSpeed;


  public Tracks(double aS){

    averageSpeed = aS;

  }

  public Tracks(){

  }

  public double oneLapSpeed(){
    double lapTime;
    lapTime = distance/averageSpeed;

    lapTime = Math.round(lapTime * 100) / 100;
    return lapTime;
  }

}
