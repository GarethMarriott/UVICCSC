

public class Queue<E>{


  private int size = 0;
  private Node<E> in;
  private Node<E> out;

  public Queue(){

  }

  public boolean isEmpty(){
    if (size == 0) {
      return true;
    }else {
      return false;
    }
  }

  public void enqueue(E element){
    Node<E> n = new Node<E>(element);
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

  public E dequeue() {
    if (size == 0){
      throw new QueueEmptyException("Empty stack upon dequeue");
    }else {
      Node<E> z = out;
      out = out.next;
      size--;
      return z.item;
    }

  }

  public E peek(){
    return out.item;
  }

  public static void main(String[] args) {
    Queue<String> q = new Queue<String>();
    System.out.println(q.isEmpty());
    q.enqueue("First");
    q.enqueue("hello");
    System.out.println(q.isEmpty());
    System.out.println(q.peek());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());

    Queue<Float> f = new Queue<Float>();
    f.enqueue(new Float(55.77));
    f.enqueue(new Float(333.333));
    System.out.println("\n"+f.isEmpty());
    System.out.println(f.dequeue());
    System.out.println(f.dequeue());
    System.out.println(f.isEmpty());
  }
}
