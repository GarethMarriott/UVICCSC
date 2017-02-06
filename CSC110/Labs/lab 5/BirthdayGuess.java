/*
Gareth Marriott
V00875748
BirthdayGuess is a guessing game
*/
import java.util.Scanner;
public class BirthdayGuess{

public static void main(String[] args) {
monthToString();
numDaysInMonth();
guessMyBirthday();
}

// Takes the number of a month and outputs its string
// @param month a number between 1 and 12
// @return the abbr. name of the month
public static String monthToString(int month){

  if(month == 1) {return "jan"}
  else if(month == 2) {return "feb"}
  else if(month == 3) {return "mar"}
  else if(month == 4) {return "apl"}
  else if(month == 5) {return "may"}
  else if(month == 6) {return "jun"}
  else if(month == 7) {return "jul"}
  else if(month == 8) {return "aug"}
  else if(month == 9) {return "sep"}
  else if(month == 10) {return "oct"}
  else if(month == 11) {return "nov"}
  else if (month == 12) {return "dec"}
  else {}
  return "broken";

}

// Takes the month and outputs the number of days in that month
// @param month a number between 1 and 12
// @return # of days in givin month
public static int numDaysInMonth(int month){
  switch (month) {
    case 1:
    case 3:
    case 5:
    case 7:
    case 9:
    case 11:
      return 31;
    case 2:
      return 29;

    default:
      return 30
  }
}

// main guessing method
public static void guessMyBirthday(){
  Scanner sc = new Scanner(System.in);
  int monthGuess;
  int dayGuess;

  monthGuess = 6;
  System.out.print("Is your birthday in " + monthToString() + ": Yes or No?");
  String answer = sc.next();
}

}
