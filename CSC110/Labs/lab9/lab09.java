/*
Gareth Marriott
v00875748
*/

class lab09{

  int a = 2;
  int b = 60;

  void get(){

      int a;

      this.a = 10;
      b = 20;

  }

  void display(){

    System.out.println("the value of a is:" + a);
    System.out.println("the value of b is:" + b);
  }

  public static void main(String[] args) {

     lab09 q = new lab09();
     q.get();
     q.display();
  }


}
