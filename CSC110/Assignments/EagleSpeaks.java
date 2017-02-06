/*
Gareth Marriott
V00875748
*/

import java.util.Scanner;
public class EagleSpeaks{

public static void main(String[] args) {

  Scanner console = new Scanner(System.in);
  System.out.print("What would you like the Eagle to say?");
  String text = console.nextLine();
  int y = text.length();
  System.out.println("                /");
  System.out.println("\\             /*/");
  System.out.println(" \\\\\\\' ,      / //");
  System.out.println("  \\\\\\//    _/ //\'");
  System.out.println("   \\_-//\' /  //<\'");
  System.out.println("    \\*///  <//\'");
  System.out.println("    /  >>  *\\\\\\`");
  System.out.println("   /,)-^>>  _\\`");
  System.out.println("   (/  \\\\  / \\\\\\");
  System.out.println("       //   //\\\\\\");
  System.out.println("  /   ((");
  System.out.println(" /");
  Speakoutside(y);
  Speak(y , text);
  Speakoutside(y);

}
  public static void Speakoutside(int y){
  System.out.print("*");
    for(int i=1; i<=y+2; i=i+1){
  System.out.print("-");
}
  System.out.println("*");
  }
  public static void Speak(int y , String text){
    System.out.print("| "+text+" |");
    System.out.println();
  }
}
