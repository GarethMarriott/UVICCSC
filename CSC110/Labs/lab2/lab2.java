import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class lab2{

public static void main(String[] args) {
  String hook = "this is a good day";
  String twin = "this is not a good day";
  Scanner sc = new Scanner(System.in);
System.out.println("print 24");
int thread=sc.nextInt();
int twine=24;
  if(thread==twine){
    System.out.println("they are the same");
  }else{
    System.out.println("they are not the same");
}
    file_reader("gareth.txt");
    testword();
    testimput();
    Forlooptest();
    Forlooptest2();
    Forloop3();
}

public static void file_reader(String filename){
  try{
Scanner filereader = new Scanner(new File(filename));
while(filereader.hasNextLine()){
  String line = filereader.nextLine();
  System.out.println(line);
}
}
catch (FileNotFoundException e){
  System.out.println("We could not find the file");
}
}
public static void testword(){
  System.out.println();
System.out.println("test");
System.out.println("text");

}
public static void testimput(){
  Scanner console = new Scanner(System.in);
System.out.print("whats your age?");
int age = console.nextInt();
  System.out.println(65 - age + "years until you can retire!!!");
}
public static void Forlooptest(){
  for(int i=1; i<=4; i=i+1){
    System.out.println("Gareth Marriott");
  }
}
public static void Forlooptest2(){
  int forlooptestv = 14;
  for(int y=1; y<= forlooptestv/2; y=y+1){
    System.out.println(y + " squared = " + (y*y));
}
  }
public static void Forloop3(){
 int forloop3v =101;
 for(int q=forloop3v; q > 3; q=q-1){
 System.out.println(q-1);
}
}

}
