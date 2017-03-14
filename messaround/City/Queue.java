

public class Queue{


  private int size = 0;
  private Vehicle in;
  private Vehicle out;

  public Queue(){

  }

  public boolean isEmpty(){
    if (size == 0) {
      return true;
    }else {
      return false;
    }
  }

  public void enqueue(Vehicle type){
    Vehicle n = new Vehicle(type);
    if (size == 0) {
      in = n;
      out = n;
      size++;
    }else{
      in.next = n;
      in = n;
      size++;
    }
  }

  public Vehicle dequeue() {
    if (size == 0){
      throw new QueueEmptyException("Empty stack upon dequeue");
    }else {
      Vehicle z = out;
      out = out.next;
      size--;
      return z;
    }

  }

  public Vehicle peek(){
    return out;
  }

  public static void main(String[] args) {

  }
}
