/*
V00875748
Gareth Marriott


*/
public class ObjStack{

  public Node top;
  public int count;

  public ObjStack(){

  }

  public boolean isEmpty(){
    if (top == null) {
      return true;
    }else {
      return false;
    }
  }

  public Node peak() throws StackEmptyException{
    if (this.isEmpty()) {
      throw new StackEmptyException();
    }else {
      return top;
    }
  }

  public Node pop(){
    if(this.isEmpty()){
      throw new StackEmptyException();
    }else {
      Node out = top;
      top = top.next;
      return out;
    }
  }

  public void push(Node n){
    n.next = top;
    top = n;
  }

  public static void main(String[] args) {
    ObjStack s = new ObjStack();
    s.push(new Node(4));
    s.push(new Node(8));
    System.out.println(s.pop().item);
    System.out.println(s.peak().item);
    System.out.println(s.pop().item);
    System.out.println(s.isEmpty());

    for (int i = 0; i < 8000; i++) {
      s.push(new Node(i));
      //System.out.println(s.peak().item);
    }
    System.out.println(s.isEmpty());

  }


}
