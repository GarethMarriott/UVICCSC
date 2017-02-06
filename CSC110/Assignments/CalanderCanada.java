/*
Gareth Marriott
V00875748
*/
import java.util.Scanner;
public class CalanderCanada{

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
  System.out.println("Lets create a mock calander!");
  System.out.print("How many days are in your month of choice?");
  int Length = sc.nextInt();
  System.out.println();
  System.out.print("What is the date that the first Sunday falls on?");
  int Date = sc.nextInt();
  System.out.println();
  int Datet=Date;   // For rightJustifymain

if(Date<1 || Date>7){                                  //Error Message
System.out.println("Error!! Please enter Valid Numbers!!");
}else if(Length >= 100 || Length <= 6 ){
  System.out.println("Error!! Please enter Valid Numbers!!");
}else{
  System.out.println("   Su    Mo    Tu    We    Th    Fr    Sa  ");
  PrintSeparator();
  if(Date!=1){    // Test to see if first line is needed
    rightJustifyfirst(Date);
  }else{}
    rightJustifymain(Date , Length , Datet);
    PrintSeparator();
}
}

public static void PrintSeparator(){
  System.out.println("+-----+-----+-----+-----+-----+-----+-----+");
}
/* Started the first line of Calander by letting the first week count up from negative values and just printing white space when
Date2<1 */
public static void rightJustifyfirst(int Date){
  int Date2=Date-1;
  for(int y=1; y<=7-Date2; y++){
    System.out.print("|");
    System.out.print("     ");
  }
  for(int z=1; z<=Date2; z++)
    System.out.print("|   "+z+" ");

System.out.println("|");
}


public static void rightJustifymain(int Date , int Length , int Datet){
for (int q=1; q<=Length/7+2; q++){
  if(Datet<=Length){
    for(int i=1; i<=7; i++){
      System.out.print("|");
        if (Date<=0 || Date>Length){
          System.out.print("     ");
        }else{
          if(Date<10){
            System.out.print("   "+Date+" ");
          }else{
            System.out.print("  "+Date+" ");
        }
        }
    Date= Date+1;
    }
  Datet=Datet+7;
  System.out.println("|");
  }else{}
}
}
}
