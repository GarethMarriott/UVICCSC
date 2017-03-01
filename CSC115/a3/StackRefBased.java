public class StackRefBased<T> implements Stack<T> {

    private int count;
    private StackNode<T> top;

    public StackRefBased() {
      count = 0;
      top = null;
    }

    public int size() {
        return count;
    }


    public boolean isEmpty() {
        if (count == 0) {
          return true;
        }else {
          return false;
        }
    }


    public void push(T data) {
        StackNode<T> n = new StackNode<T>(data);
        n.next = top;
        top = n;
        count++;
    }


    public T pop() throws StackEmptyException {
        if (this.isEmpty()) {
          throw new StackEmptyException("Empty Stack!");
        }else {
          StackNode<T> out = top;
          top = top.next;
          count--;
          return out.data;
        }
    }


    public T peek() throws StackEmptyException {
        T cur = this.pop();
        this.push(cur);
        return cur;
    }


    public void makeEmpty() {
      top = null;
      count = 0;
    }


    public String toString() {
        String str = "";
        while (count > 0) {
          try {
            str = this.pop().toString()+str;
            if (count != 0){
              str = " "+str;
            }
          }catch (Exception e) {
            e.printStackTrace(System.out);
            System.exit(1);
          }
        }
        return str;
    }


    public static void main(String[] args) throws StackEmptyException {
      Stack<Integer> stack = new StackRefBased<Integer>();
      stack.push(5);
      stack.push(8);
      System.out.println(stack.peek());
      System.out.println(stack);

      Stack<String> stackS = new StackRefBased<String>();
      stackS.push("Hello");
      stackS.push("World");
      System.out.println(stackS.peek());
      stackS.push("Java");
      System.out.println(stackS.pop());
      System.out.println(stackS);

    }
}
