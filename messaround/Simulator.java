/*

a -- c"1" -- b"2"->"7" -- null

*/

import java.util.*;

public class Simulator{

//*Colours*
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_YELLOW = "\u001B[33m";
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_PURPLE = "\u001B[35m";
public static String currentTrackName;

  public static void main(String[] args) {

    String carName;
    String trackName;
    double averageSpeed;

    Scanner sc = new Scanner(System.in);

    System.out.println();
    System.out.println();
    System.out.println("Welcome to the \"SUPER HIGH TECH\" race car track simulator!"+ANSI_GREEN+"\nPlease enter the name of the race car you would like to race!\nIf you want to use the specs of kyle busch's #51 Nascar enter: \'NASCAR\'"+ANSI_RESET);
    carName = sc.nextLine();
    if (carName.equals("NASCAR")) {
      carName = "kyle busch's #51 NASCAR";
      averageSpeed = 212.08;
    }
    else {
      System.out.println(ANSI_GREEN+"\nNow enter the average speed of the car! (KMH)"+ANSI_RESET);

      while(sc.hasNextInt() != true)
      {
        System.out.println(ANSI_RED + "**ERROR**  please enter a valid number");
        sc.nextLine();
      }
      averageSpeed = sc.nextInt();
      sc.nextLine();
      averageSpeed = averageSpeed / 3.6;
    }

    //TO satisfy compiler
    Tracks CurrentTrack = new Tracks("broken" , 9999);


    // Prompts user for a track from list
    // Initializes a new Track within trackSwitcher method
    CurrentTrack = trackSwitcher(sc , CurrentTrack , carName , averageSpeed);

    System.out.println("\nNow you can see a bunch of facts about how your car would do on the race track!");
    //System.out.println(ANSI_RED + "\nEnter the characters \'help\' to see your options!" + ANSI_RESET);
    System.out.println(ANSI_YELLOW + "\nOptions:\n\'exit\': Exits program\n\'laptime\': The speed it takes to do one lap\n\'switch\': brings up a list of race tracks you can switch to\n\'racetime\': Lets you determine how long it would take to compleate the whole race\n\'change laps\': Lets you change the number of laps currently racing\n***note tracks such as le Mans have a time limit not a lap limit by default***   Currently:"+CurrentTrack.laps + ANSI_RESET);



    while (true){

      System.out.println();
      System.out.println(ANSI_GREEN+"please enter an input to get stats about your car on the track! (if you dont know what to do enter \'help\')\n"+ANSI_RESET);
      String input = sc.nextLine();
      input.toLowerCase();
      System.out.println();

      if (input.equals("help")) {
        System.out.println(ANSI_YELLOW + "\nOptions:\n\'exit\': Exits program\n\'switch\': brings up a list of race tracks you can switch to\n\'laptime\': The speed it takes to do one lap\n\'racetime\': Lets you determine how long it would take to compleate the whole race\n\'change laps\': Lets you change the number of laps currently racing\n***note tracks such as le Mans have a time limit not a lap limit by default***   Currently:"+CurrentTrack.laps + ANSI_RESET);
      }

      else if (input.equals("exit")) {
        break;
      }

      // Calls .oneLapSpeed in CurrentTrack and returns laptime in seconds
      else if (input.equals("laptime")) {
        double lapTime = CurrentTrack.oneLapSpeed();
        System.out.println(ANSI_PURPLE + carName + " is going around the track once every " + lapTime + " seconds!" + ANSI_RESET);
      }

      else if (input.equals("switch")) {
        CurrentTrack = trackSwitcher(sc , CurrentTrack , carName , averageSpeed);
      }

      else if (input.equals("racetime")) {
        double raceTime = CurrentTrack.raceLength();
        double raceTimeHours = raceTime/3600
        System.out.println(ANSI_PURPLE + "your vehicle "+ carName + " would compleate the " + CurrentTrack.laps + " lap race at " + currentTrackName + " in:" + raceTime + " second or " + raceTime/3600 + " hours"+ ANSI_RESET);
      }

      //Prompts User for new input about number of laps
      //rePrompts if bad input
      //applies input directly to variable in CurrentTrack
      else if(input.equals("change laps"))
      {
        int inLaps;
        System.out.println(ANSI_GREEN+"please enter the number of laps you want to race!"+ANSI_RESET);
        while(sc.hasNextInt() != true)
        {
          System.out.println(ANSI_RED + "ERROR" + ANSI_RESET + "\n" + ANSI_GREEN+"please enter the number of laps you want to race!"+ANSI_RESET);
          sc.nextLine();
        }
        inLaps = sc.nextInt();
        CurrentTrack.laps = inLaps;
        sc.nextLine();
      }

      else {
        System.out.println(ANSI_RED + "please enter a valid input" + ANSI_RESET);
      }

    }

  }



  public static Tracks trackSwitcher(Scanner sc , Tracks CurrentTrack , String carName , double averageSpeed){
    while (true) {
      System.out.println();
      System.out.println("Enter the name of the track you want to see from the list below:"+ANSI_YELLOW+"\nDaytona\nAtlanta\nle Mans\nWestern Speedway\ndarlington\nlas vegas"+ANSI_RESET);
      String input = sc.nextLine();
      currentTrackName = input;
      input = input.toLowerCase();

      if (input.equals("daytona")) {
        CurrentTrack = new Tracks(carName , averageSpeed , 5000 , 200);
        break;
      }

      else if (input.equals("atlanta")) {
        CurrentTrack = new Tracks(carName , averageSpeed , 2480 , 325);
        break;
      }

      else if (input.equals("le mans")) {
        CurrentTrack = new Tracks(carName , averageSpeed , 13629 , 0);
        break;
      }

      else if (input.equals("western speedway")) {
        CurrentTrack = new Tracks(carName , averageSpeed , 644 , 50);
        break;
      }

      else if (input.equals("darlington")) {
        CurrentTrack = new Tracks(carName , averageSpeed , 2200 , 367);
        break;
      }

      else if (input.equals("las vegas")) {
        CurrentTrack = new Tracks(carName , averageSpeed , 2400 , 267);
        break;
      }

      else {
      System.out.println(ANSI_RED+"please enter a valid input from the list"+ANSI_RESET);
      }
  }
  return CurrentTrack;

}
}
