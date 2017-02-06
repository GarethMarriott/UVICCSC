import java.util.Scanner;
public class Lab3{
  public final static int Tester1 = 7;

public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  System.out.println("enter first number");
  int a = sc.nextInt();
  System.out.println("enter second number");
  int b = sc.nextInt();
  System.out.println("Sum "+(a+b));
  System.out.println();
  System.out.println();
  System.out.println();
  System.out.println("Enter a Number greater then 10 to continue");
  double c = sc.nextDouble();
  Rectangle();
  Forlooptest();
  Line(4);
  System.out.println();
  Box(4, 5);
}

public static void Rectangle(){
  Scanner sc = new Scanner(System.in);
  System.out.println("Calculate the area of a Rectangle!!");
  System.out.println("What units are you using?");
  String unit = sc.nextLine();
  System.out.println("Length?");
  int x = sc.nextInt();
  System.out.println("Width?");
  int y = sc.nextInt();
  int z = x*y;
  System.out.println("the area is "+ z + unit);

}
public static void Forlooptest(){
  for(int i=1; i<=10; i=i+1){
    System.out.println("Gareth Marriott");
}
System.out.println(Tester1);
}
public static void Line(int Ln){
  for(int i=1; i<=Ln; i++)
  System.out.print("-_-");
}

public static void Box(int W, int H){
  for(int i=1; i<=H; i++){
    System.out.println();
    if(i==1 || i==H){
      for(int Q=1; Q<=W; Q++){
        System.out.print("*");
      }
    }else{
      for(int P=1; P<=W; P++){
        if(P==1 || P==W){
          System.out.print("*");
        }else{
          System.out.print(" ");
        }
    }
    }

}
}


}
