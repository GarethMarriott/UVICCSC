
public class RectList implements List{

public  RectNode head;
public  RectNode tail;
private int count;

public RectList()
{
    RectNode head = null;
    RectNode tail = null;
    int count = 0;
}

public boolean isEmpty()
{
  if (head == null)
  {
    return true;
  }
  else
  {
    return false;
  }
}

public int size()
{
  return  count;
}

public void append(Rectangle r)
{
    RectNode n = new RectNode(r);
    tail.next = n;
    tail = n;
    if (count == 0) {
        head = tail;
    }
    count++;
}

public void prepend(Rectangle r)
{
  RectNode n = new RectNode(r , head);
  head = n;
  if (count == 0) {
    tail = head;
  }
  count++;
}

public String toString()
{
  String out = "";
  // for (int i = 0; i < count; i++) {
  //   out += "\n\t"+head.next;
  // }
  RectNode p = head;
  while (p!=null) {
    out+=p.item.toString();
    if (p.next != null) {
      out+="\n\t";
    }
    p = p.next;
  }
  return "List: size = " + size() + "\n\t" + out;
}

public static void main(String[] args) {

    RectList list = new RectList();
    Rectangle a = new Rectangle(4 , 6);
    Rectangle b = new Rectangle(999 , 777);
    Rectangle c = new Rectangle(11 , 22);

    System.out.println(list.isEmpty());
    list.prepend(a);
    System.out.println(list);
    list.append(b);
    System.out.println(list.size());
    System.out.println(list.isEmpty());
    list.append(c);
    System.out.println(list);
}

}
