/*
 * Name: Gareth Marriott
 * Student Number: V00875748
 */

public class IntegerLinkedList implements IntegerList
{
	public IntegerNode head = null;
	public IntegerNode tail = null;
	public int count = 0;
	public IntegerLinkedList()
	{

	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{
		IntegerNode n = new IntegerNode(x);
		count++;
		n.next = head;
		head = n;
		if (count == 1) {
			tail = n;
		}else {
			n.next.prev = n;
		}
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */
	public void addBack (int x)
	{
		IntegerNode n = new IntegerNode(x);
		count++;
		if (count == 1) {
			head = n;
		}else {
			n.prev = tail;
			tail.next = n;
		}
		tail = n;
	}

	/*
	 * PURPOSE:
	 *   Add the element x at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for addAt are
	 *   0, 1, 2, 3.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos <= l.size()
	 *
	 * Examples:
	 *
	 * If l is {} and l.addAt(9,0) returns, then l is {9}.
	 * If l is {1} and l.addAt(9,0) returns, then l is {9,1}.
	 * If l is {1,2} and l.addAt(9,1) returns, then l is {1,9,2}
	 * If l is {1,2} and l.addAt(9,2) returns, then l is {1,2,9}
	 */
	public void addAt (int x, int pos)
	{
		IntegerNode q = head;
		for (int i = 0; i < pos; i++) {
			q = q.next;
		}

		if (pos == 0) {
			this.addFront(x);
		}
		else if (pos == this.size()){
			this.addBack(x);
		}
		else {
			IntegerNode n = new IntegerNode(x);
			count++;
			IntegerNode r = q.prev;
			n.next = q;
			n.prev = r;
			r.next = n;
			q.prev = n;

		}

	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return count;
	}

	/*
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 *
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
		IntegerNode p = head;
		for (int i = 0; i < pos; i++) {
			p = p.next;
		}
		return p.value;
	}

	/*
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Remove all instances of value from the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{
	}

	/*
	 * PURPOSE:
	 *   Remove the element at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for removeAt are
	 *   0, 1, 2.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *
	 * If l is {1} and l.removeAt(0) returns, then l is {}.
	 * If l is {1,2,3} and l.removeAt(1) returns, then l is {1,3}
	 * If l is {1,2,3} and l.removeAt(2) returns, then l is {1,2}
	 */
	public void removeAt (int pos)
	{
		IntegerNode p = head;
		for (int i = 0; i < pos; i++) {
			p = p.next;
		}
		if (pos == 0) {
			head = p.next;
			p.next.prev = null;
		}else if (pos == count) {
			tail = p.prev;
			p.prev.next = null;
		}
		else {
		p.prev.next = p.next;
		p.next.prev = p.prev;
		}
	}

	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		String s = "{";
		IntegerNode p = head;
		for (int i = 0; this.size() > i; i++) {
			s += p.value;
			if (count-1 > i) {
				s+= ",";
			}
			p = p.next;
		}
		s += "}";
		return s;
	}
}
