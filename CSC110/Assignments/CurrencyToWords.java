/*
Gareth Marriott
V00875748
*/

import java.util.Scanner;

public class CurrencyToWords {

  public static void main(String[] args) {
    double Value = GetValueFromUser();
//     double Value = 1110.92;
    BaseCardinalToString(Value);

  }
  public static double GetValueFromUser(){
    Scanner sc = new Scanner(System.in);
    System.out.print("Please enter a numerical value: ");

    while(! sc.hasNextDouble()){
    sc.nextLine();
    System.out.println("Please enter a valid imput");
  }

    double value = sc.nextDouble();
    return value;

  }

  public static void BaseCardinalToString(double Value){

    int rounded  = (int) Value;

    int cents       = getCents(Value);
    String dollars  = getDollars(rounded);
    String hundreds = getHundreds(rounded);
    String thousands= getThousands(rounded);


    String sizeHundreds = hundreds  == ""     ? "" : " hundred";
    String and          = dollars == "" ? "" : " and ";
    String sizeThousands= thousands == ""     ? "" : " thousand ";
    if(rounded < 100){
    	and = "";
    }


    String check =( thousands + sizeThousands + hundreds + sizeHundreds + and + dollars  + cents + "/100 dollars");
    int length = 70 - check.length();
    String dots = "";
    for(int i=1; i<=length; i++){
    	dots = dots + ".";
    }

    System.out.print( thousands + sizeThousands + hundreds + sizeHundreds + and + dollars + dots + cents + "/100 dollars");

  }

  public static int getCents(double Value) {
    int Rounded     = (int)Value;
    double ValueEnd = Value-Rounded;
    ValueEnd        = ValueEnd*100;
    return (int)(ValueEnd+0.5);//Correct "cent" is ValueEnd2
  }

  public static String getDollars(int dollars) {
    String dollarsAsStr = new Integer(dollars).toString();
    String s;
    if (dollars % 100 >= 10 ){
      s = dollarsAsStr.substring(dollarsAsStr.length() - 2);
    }else{
      s = dollarsAsStr.substring(dollarsAsStr.length() - 1);
    }
    String word = valToWord(Integer.parseInt(s));
    return word;
  }

  public static String getHundreds(int dollars) {
    if ( dollars < 100 ) return "";

    String dollarsAsStr = new Integer(dollars).toString();
    String s = dollarsAsStr.substring(dollarsAsStr.length() - 3, dollarsAsStr.length() - 3 + 1);
	String word = valToWord(Integer.parseInt(s));

    return word;
  }

  public static String getThousands(int dollars) {
    if ( dollars < 1000 ) return "";
    if ( dollars == 10000 ) return "ten";
    String dollarsAsStr = new Integer(dollars).toString();
    String s = dollarsAsStr.substring(dollarsAsStr.length() - 4, dollarsAsStr.length() - 4 + 1);
    String word = valToWord(Integer.parseInt(s));
    return word;
  }

  public static String valToWord(int val) {
    if ( val == 0 ) return "";
    if ( val == 1 ) return "one";
    if ( val == 2 ) return "two";
    if ( val == 3 ) return "three";
    if ( val == 4 ) return "four";
    if ( val == 5 ) return "five";
    if ( val == 6 ) return "six";
    if ( val == 7 ) return "seven";
    if ( val == 8 ) return "eight";
    if ( val == 9 ) return "nine";
    if ( val == 10 ) return "ten";
    if ( val == 11 ) return "eleven";
    if ( val == 12 ) return "twelve";
    if ( val == 13 ) return "thirteen";
    if ( val == 14 ) return "fourteen";
    if ( val == 15 ) return "fifteen";
    if ( val == 16 ) return "sixteen";
    if ( val == 17 ) return "seventeen";
    if ( val == 18 ) return "eighteen";
    if ( val == 19 ) return "nineteen";
    if ( val == 20 ) return "twenty";
    if ( val > 20 && val < 30){
      String val10s   = "" + val % 10;
      String the20soutput = "twenty-" + valToWord(Integer.parseInt(val10s));
      return the20soutput;
    }
    if ( val == 30 ) return "thirty";
    if ( val > 30 && val < 40){
      String val10s   = "" + val % 10;
      String the30soutput = "thirty-" + valToWord(Integer.parseInt(val10s));
      return the30soutput;
    }
    if ( val == 40 ) return "forty";
    if ( val > 40 && val < 50){
      String val10s   = "" + val % 10;
      String the40soutput = "forty-" + valToWord(Integer.parseInt(val10s));
      return the40soutput;
    }
    if ( val == 50 ) return "fifty";
    if ( val > 50 && val < 60){
      String val10s   = "" + val % 10;
      String the50soutput = "fifty-" + valToWord(Integer.parseInt(val10s));
      return the50soutput;
    }
    if (val == 60 ) return "sixty";
    if (val > 60 && val < 70){
      String val10s   = "" + val % 10;
      String the60soutput = "sixty-" + valToWord(Integer.parseInt(val10s));
      return the60soutput;
    }
    if (val == 70) return "seventy";
    if (val > 70 && val < 80){
      String val10s   = "" + val % 10;
      String the70soutput = "seventy-" + valToWord(Integer.parseInt(val10s));
      return the70soutput;
    }
    if ( val == 80) return "eighty";
    if (val > 80 && val < 90){
      String val10s   = "" + val % 10;
      String the80soutput = "eighty-" + valToWord(Integer.parseInt(val10s));
      return the80soutput;
    }
    if ( val == 90) return "ninety";
    if ( val > 90 && val < 100 ){
      String val10s   = "" + val % 10;
      String the90soutput = "ninety-" + valToWord(Integer.parseInt(val10s));
      return the90soutput;
    }
    return "still need to handle";
  }

}
