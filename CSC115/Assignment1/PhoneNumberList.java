public class PhoneNumberList
{
	private static final int INITIAL_SIZE = 2;

	private PhoneNumber[]	storage;
	private int		count;

	//
	// Purpose:
	//	Initialize a new instance of PhoneNumberList
	//
	public PhoneNumberList()
	{
		storage = new PhoneNumber[2];
		count = 0;
	}

	//
	// Purpose:
	// 	return the element at position index
	//
	// Pre-Conditions:
	// 	for a PhoneNumberList x:
	//	index >= 0 AND
	//	index < x.size()
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then:
	//	x.get(0) returns "Work:5551212"
	//	x.get(1) returns "Home:4441212"
	//	the result of calling x.get(3) is undefined
	//
	public PhoneNumber get (int index)
	{
		return storage[index];
	}

	//
	// Purpose:
	//	remove the element at position index
	//
	// Pre-Conditions:
	//	for a PhoneNumberList x:
	//		index >= 0 AND
	//		index < x.size()
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then
	//	after x.remove(0), x is {"Home:4441212", "Cell:3331212"}
	//
	public void remove (int index)
	{
		for (int i = index; i < storage.length-index-1; i++) {
			storage[i] = storage[i+1];
		}
	count--;

		// for (int i = 0; i < storage.length - 1; i++) {
		// 	if ((storage[i].toString()).equals(storage[index].toString())) {
		// 		for (int j = index; j < storage.length + 1; j++)
		// 		{
		// 			storage[index] = storage[index+1];
		// 		}
		// 		storage[storage.length - 1] = null;
		// 	}
		// }
		// count = count - 1;
	}

	//
	// Purpose:
	//	return the number of elements in the list
	//
	// Returns:
	//	the number of elements in the list
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212"}
	//	x.size() returns 2
	// If x is {}
	//	x.size() returns 0
	//
	public int size()
	{
		return count;
	}

	//
	// Purpose:
	//	add the phone number p to the list
	//
	// Comments:
	//
	//	The array you allocated to store PhoneNumbers might
	//	get full, but you are still required to add this
	//	PhoneNumber (until the JVM runs out of memory!)
	//
	//	This means that you should check to see if the array
	//	is currently full.  If it is, allocate a new array
	// 	that is twice as big, then copy the values over
	//	and update the storage reference to be the new array
	//	Finally, add the new PhoneNumber.
	//
	public void add (PhoneNumber p)
	{
		storage[count] = p;
		count = count + 1;
		if (count == storage.length) {
			PhoneNumber[] temp = new PhoneNumber[count*2];
			for (int i = 0; i < storage.length; i++) {
				temp[i] = storage[i];
			}
			storage = new PhoneNumber[count*2];
			for (int j = 0; j < temp.length-1; j++) {
				storage[j] = temp[j];
			}
		}
	}

	//
	// Purpose:
	//	return the index where p is in the list, -1 otherwise
	//
	// Pre-Conditions:
	//	none
	//
	// Returns:
	//	position of p in the list - an integer between 0 and size() - 1
	//	-1 if p is not in the list
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then
	//
	//	PhoneNumber p = new PhoneNumber("5551212");
	//	PhoneNumber q = new PhoneNumber("3331212");
	//	PhoneNumber r = new PhoneNumber("1234567");
	//
	// 	x.find(p) returns 0
	//	x.find(q) returns 2
	//	x.find(r) returns -1
	//
	public int find (PhoneNumber p)
	{
		for (int i = 0; storage.length > i; i++)
		{
			if (storage[i] != null)
			{
				if (storage[i].equals(p))
				{
					return i;
				}
			}
		}
	return -1;
	}
}
