/*

Flow Charts
Square  =  Process
Diamond =  Decision
Rhombus  =  Data(input/output)
circle  =  Start/Stop




*****************************************************
Binary Notes

2^2  2^1  2^0
1    0    1

2^2 x 1 = 4     +     2^1 x 0 = 0    +     2^0 x 1 = 1

101 in Binary = 5


1 0 0 0 1 in Binary

  2^4   2^3   2^2   2^1   2^0
x 1      0     0     0     1
= 16  +  0  +  0  +  0  +  1
= 17

negative binary in Two's complement algorithm

Left most bit determines if negative=1 or positive=0

-5.0 =
00101
11010   <--flip
11011   <--Add 1

-10.0 =
01010
10101   <--flip
10110   <--Add 1

-17.0 =
10001
01110   <--flip
01111   <--Add 1



*******************************************************

Logic



*/


public class notes{

  public static void main(String[] args) {

    System.out.println(toBinary(11));

  }

  public static String toBinary(int in){
    String out = "";
    while (in >= 2) {
      int encoding = in % 2;
      out = out + encoding;
      in = in/2;
    }
    return out;

  }
}
