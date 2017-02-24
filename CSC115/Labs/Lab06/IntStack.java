/*
V00875748
Gareth Marriott


*/

public class IntStack{

  private int[] stack = new int[10];
  private int top = -1;

  public IntStack(){

  }

  public int peak() throws StackEmptyException{
    return stack[top];
  }

  public boolean isEmpty(){
    if (top == -1) {
      return true;
    }else {
      return false;
    }
  }

  public int pop() throws StackEmptyException{
    if (top == -1) {
      throw new StackEmptyException("Empty Stack!");
    }else {
      top--;
      return stack[top+1];
    }
  }

  public void push(int item){
    if (top != stack.length-1) {
      stack[top+1] = item;
      top++;
    }else {
      int[] temp = new int[top*2];
      for (int i = 0; i < stack.length; i++) {
        temp[i] = stack[i];
      }
      stack = new int[temp.length];
      for (int i = 0; top*2 > i; i++) {
        stack[i] = temp[i];
      }
    }
  }

  public static void main(String[] args) {

    IntStack s = new IntStack();
    s.push(5);
    s.push(8);
    System.out.println(s.isEmpty());
    System.out.println(s.peak());
    System.out.println(s.pop());
    System.out.println(s.peak());
    System.out.println(s.isEmpty());
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
    try {
      System.out.println(s.pop());
    }
    catch (Exception e) {
      System.out.println("caught");
    }

    System.out.println("stress test\n");
    for (int i = 0; i < 4000; i++) {
      s.push(i);
      System.out.println(s.peak());
    }
    System.out.println(s.peak());
    System.out.println(s.isEmpty());
    try {
      while(true){
        s.pop();
        System.out.println(s.peak());
      }
    }catch (Exception e) {
        System.out.println(s.isEmpty());
    }


  }


}
