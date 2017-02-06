/*
Gareth Marriott
V00875748
BirthdayGuess is a guessing game
*/

public class BirthdayGuess{

public static void main(String[] args) {

}

// Takes the number of a month and outputs its string
// @param month a number between 1 and 12
// @return the abbr. name of the month
public static String monthToString(int month){

  if(month == 1) return "jan";
  if(month == 2) return "feb";
  if(month == 3) return "mar";
  if(month == 4) return "apl";
  if(month == 5) return "may";
  if(month == 6) return "jun";
  if(month == 7) return "jul";
  if(month == 8) return "aug";
  if(month == 9) return "sep";
  if(month == 10) return "oct";
  if(month == 11) return "nov";
  if(month == 12) return "dec";
}

// Takes the month and outputs the number of days in that month
// @param month a number between 1 and 12
// @return # of days in givin month
public static int numDaysInMonth(int month){
  //NEEDTODO
  return 7;
}

// main guessing method
public static void guessMyBirthday(){
  //NEEDTODO
}

}
