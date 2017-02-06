/*
Gareth Marriott
V00875748
*/

import java.util.Scanner;
import java.text.*;

public class FutureValue{
public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  System.out.println("Lets calculate intrest rates!");
  System.out.println();
  System.out.print("What is your starting Value?");
  double P = sc.nextDouble();
  System.out.println();
  System.out.print("What is your intrest rate percentage if 1.00 is 100%?");
  double R = sc.nextDouble();
  System.out.println();
  System.out.print("How many years is it saved for?");
  double T = sc.nextDouble();
  System.out.println();
  DecimalFormat formatter = new DecimalFormat(".00");
  System.out.println("Year0:"+P);
  for(int i=1; i<=T; i=i+1){
    P= P+(P*R);
    String FP = String.valueOf(P);
    FP = formatter.format(P);
    System.out.print("Year"+i+":");
    System.out.print(FP);
    System.out.println();

  }
}
}
