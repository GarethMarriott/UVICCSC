import java.util.Scanner;
import java.util.Random;
import java.text.*;

class Lab4{

public static void main(String[] args) {
Guesser();
WhileLoop();
}

public static void Caller(){
  Scanner sc = new Scanner(System.in);
  System.out.println("print a word!");
  String S = sc.nextLine();
  int Q=S.length();
  int A = 80/Q;
  for(int i=1; i<=A; i++){
    System.out.println("Gareth");
  }
}

public static void Randomtest(){
  Random rd = new Random();

  for(int i=1; i<=20; i++){
    int Ran=rd.nextInt(10)+1;
    System.out.println(Ran);
  }
}
 public static void Guesser(){
   Random rd = new Random();
   Scanner sc = new Scanner(System.in);

   System.out.println("Guess a number between 1-10!! If you guess right you will get a prize!");
   int Win=1;
   while(Win==1){
   int Guess = sc.nextInt();
   int R = rd.nextInt(10)+1;
   if(Guess==R){
     System.out.println("You got it!!");
     Win=2;
   }else if (Guess>R) {
     System.out.println("Your guess was "+(Guess-R)+" more then the number! The number was "+R+". Try Again!");
   }else{
     System.out.println("Your guess was "+(R-Guess)+" less then the number! The number was "+R+". Try Again!");
   }
 }
 }

 public static void WhileLoop(){
   DecimalFormat formatter = new DecimalFormat(".00");
   Scanner sc = new Scanner(System.in);
   System.out.println("I want to make a Million Dollars!! Lets see how long it takes at 10% intrest");
   double P = sc.nextDouble();
   System.out.println("Year 0:"+P);
   int I=1;
   while(P<1000000){
     P=P+(P*0.1);
     String FP = String.valueOf(P);
     FP = formatter.format(P);
     System.out.println("Year "+I+":"+FP);
     I=I+1;
   }
 }
}
