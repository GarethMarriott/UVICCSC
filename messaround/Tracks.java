//Copyright (c) 2017 Copyright Holder All Rights Reserved.

/*
Gareth Marriott
v00875748
*/

public class Tracks{

  private double lapDistance = 4000.0;
  private String carName;
  private double averageSpeed;
  public int laps;


  public Tracks(String c , double aS){

    carName = c;
    averageSpeed = aS;

  }

  public Tracks(String c , double aS , double d , int l){

    carName = c;
    averageSpeed = aS;
    lapDistance = d;
    laps = l;
  }

  //@Returns time it takes the car to do one lap in SECONDS
  public double oneLapSpeed(){
    double lapTime;
    lapTime = lapDistance/averageSpeed;

    lapTime = Math.round(lapTime * 100) / 100;
    return lapTime;
  }

  //@returns the time it takes to finish the race in HOURS
  // IF RACE HAS SPECIFIED LENGTH ex. LE MANS @returns 0
  public double raceLength(){
    double raceTime;

    raceTime = oneLapSpeed() * laps;
    if (raceTime == 0) {
      return 0;
    }
    return raceTime;
  }


  public String toString(){
    return "\nWelcome to the \'SUPER HIGH TECH\' race track simulator\nYour car name: " + carName;
  }
  //
  // public static void main(String[] args) {
  //
  //   Tracks t1 = new Tracks("Toyota" , 100.5);
  //   Tracks t2 = new Tracks("Honda" , 95 , 5000);
  //   Tracks t3 = new Tracks("Jeep" , 80 , 3000);
  //
  //   System.out.println(t1.toString());
  //   System.out.println(t1.oneLapSpeed());
  //   System.out.println(t2.toString());
  //   System.out.println(t2.oneLapSpeed());
  //   System.out.println(t3.toString());
  //   System.out.println(t3.oneLapSpeed());
  //
  //   // double test =  1.1;
  //   // String test2  = "hello";
  //   // System.out.println(test + test2);
  //
  // }

}
