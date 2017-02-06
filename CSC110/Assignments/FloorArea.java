/*
Gareth Marriott
V00875748
*/

public class FloorArea{
public static void main(String[] args) {

int naveArea = 18*85;
double chancelArea = Math.PI*(9*9)/2;//used formula pi R^2
double chapelAreaSmall = Math.PI*(4.5*4.5)/2;
double chapelAreaLarge = Math.PI*(8*8)/2;
double totalArea = naveArea+chancelArea+chapelAreaLarge+chapelAreaSmall+chapelAreaLarge;
System.out.println(totalArea);

}
}
