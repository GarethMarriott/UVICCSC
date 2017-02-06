/*
 *  Gareth Marriott
 *
 *  V00875748
*/


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

public int getIndex(Rectangle r){
  int index = 0;
  for (RectNode temp = head; temp != null ; temp = temp.next) {
    if (temp.item.equals(r)) {
      return index;
    }
    else {
      index++;
    }
  }
  return -1;
}

public Rectangle findAtIndex(int index){
  RectNode temp = head;
  for (int i = 0; i < index; i++) {
    temp = temp.next;
  }
  return temp.item;
}

public void remove(Rectangle r){
  if (count == 0) return;
  int pos = getIndex(r);
  if (pos == -1) return;
  if (pos == 0) {
    head = head.next;
    count--;
  }
  else{
      RectNode current = head;
      RectNode previous = head;
      while (current != null) {
        if (current.item.equals(r)) {
          previous.next = current.next;
          current = current.next;
          count--;
        }
        else{
          previous = current;
          current = current.next;
        }
      }
    }
  }

  public void insertAtPos(Rectangle r, int pos){
    if (pos == 0) {
      prepend(r);
      return;
    }
    if (pos == count-1) {
      append(r);
      return;
    }
    RectNode previous = head;
    for (int i = 0; i<pos-1 ; i++) {
      previous = previous.next;
    }
    RectNode n = new RectNode(r);
    n.next = previous.next;
    previous.next = n;
    count++;
  }

public static void main(String[] args) {

    RectList list = new RectList();
    Rectangle a = new Rectangle(4 , 6);
    Rectangle b = new Rectangle(999 , 777);
    Rectangle c = new Rectangle(11 , 22);
    Rectangle d = new Rectangle(666 , 333);
    Rectangle e = new Rectangle(1 , 2);

    System.out.println(list.isEmpty());
    list.prepend(a);
    System.out.println(list);
    list.append(b);
    System.out.println(list.size());
    System.out.println(list.isEmpty());
    list.append(c);
    System.out.println(list);
    System.out.println();
    System.out.println();
    System.out.println("TEST 2");
    System.out.println(list.getIndex(a));
    System.out.println(list.findAtIndex(1));
    list.remove(a);
    System.out.println(list);
    list.insertAtPos(d , 0);
    list.insertAtPos(a , list.size());
    System.out.println("TEST 3");
    System.out.println();
    list.insertAtPos(e , 2);
    System.out.println(list);


}

}
