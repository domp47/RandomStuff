package Lab8;

import BasicIO.*;

public class ListOps {

	// private ASCIIDisplayer display;

	public ListOps() {

		ASCIIDataFile dataFile;
		List aList;
		List bList;

		// display = new ASCIIDisplayer();
		dataFile = new ASCIIDataFile();
		/*
		 * aList = load(dataFile); dataFile.close(); display.writeString(
		 * "List: "); print(aList); display.newLine(); display.writeString(
		 * "Length: "); display.writeInt(length(aList)); display.newLine();
		 * display.writeString("Reverse: "); printReverse(aList);
		 * display.newLine(); display.writeString("Sum: ");
		 * display.writeInt(sum(aList)); display.newLine(); display.writeString(
		 * "Max: "); display.writeInt(max(aList)); display.newLine();
		 * display.writeString("Contains (3): ");
		 * display.writeBoolean(contains(aList,3)); display.newLine();
		 * display.writeString("Contains (6): ");
		 * display.writeBoolean(contains(aList,6)); display.newLine(); bList =
		 * copy(aList); display.writeString("List (copy): "); print(bList);
		 * display.newLine(); display.writeString("Length (copy): ");
		 * display.writeInt(length(bList)); display.newLine();
		 * display.writeString("Equals copy: ");
		 * display.writeBoolean(equals(aList,bList)); display.newLine(); bList =
		 * plusOne(aList); display.writeString("List (plusOne): ");
		 * print(bList); display.newLine(); display.writeString(
		 * "Length (plusOne): "); display.writeInt(length(bList));
		 * display.newLine(); display.writeString("Equals copy (plusOne): ");
		 * display.writeBoolean(equals(aList,bList)); display.newLine(); bList =
		 * append(aList,bList); display.writeString("List (append): ");
		 * print(bList); display.newLine(); display.writeString(
		 * "Length (append): "); display.writeInt(length(bList));
		 * display.newLine(); bList = reverse(aList); display.writeString(
		 * "List (reverse): "); print(bList); display.newLine();
		 * display.writeString("Length (reverse): ");
		 * display.writeInt(length(bList)); display.newLine();
		 */

		aList = load(dataFile);
		print(aList);
		System.out.println();
		System.out.println(length(aList));
		System.out.println(sum(aList));
		System.out.println(max(aList));
		System.out.println(contains(aList, 3));
		printReverse(aList);
		System.out.println();
		System.out.println(equals(aList, aList));
		print(plusOne(aList));
		System.out.println();
		//System.out.println(Append(aList,Reverse(aList)));
		System.out.println(Append(aList,aList));
		// display.close();
		dataFile.close();
	}; // constructor

	public List load(ASCIIDataFile in) {
		List aList = null;
		int v = in.readInt();

		if (in.isEOF())
			return null;

		aList = new List(v, load(in));

		return aList;
	}

	public void print(List aList) {
		System.out.print(aList.head);
		if (aList.tail != null)
			print(aList.tail);
	}

	public int length(List l) {
		if (l == null)
			return 0;
		int c = 1 + length(l.tail);

		return c;
	}

	public void printReverse(List l) {
		if (l == null)
			return;
		printReverse(l.tail);
		System.out.print(l.head);

	}

	public int sum(List l) {
		if (l == null)
			return 0;
		int s = l.head + sum(l.tail);

		return s;
	}

	public int max(List l) {
		int m = Integer.MIN_VALUE;

		if (l == null)
			return m;

		m = Math.max(max(l.tail), l.head);

		return m;
	}

	public boolean contains(List l, int x) {
		if (l == null)
			return false;
		else {
			if (l.head == x)
				return true;
			else
				return contains(l.tail, x);
		}
	}

	public List copy(List l) {
		List aList = null;

		if (l == null)
			return null;

		aList = new List(l.head, copy(l.tail));

		return aList;
	}

	public boolean equals(List l1, List l2) {
		if (l1 == null & l2 == null)
			return true;
		else if (l1 == null || l2 == null)
			return false;
		else if (l1.head != l2.head)
			return false;
		else
			return equals(l1.tail, l2.tail);

	}

	public List plusOne(List l) {
		List aList = null;

		if (l == null)
			return null;

		aList = new List(l.head+1, plusOne(l.tail));

		return aList;
	}

	public List Append(List l1, List l2) {
		List aList;

		if (l1 == null) {
			if (l2 == null)
				return null;
			aList = new List(l2.head, Append(l1, l2.tail));
		}

		aList = new List(l1.head, Append(l1.tail, l2));

		return aList;
	}

	public List Reverse(List l) {
		if (l == null) {
			return null;
		}
		
		return Append(Reverse(l.tail),new List(l.head, null));
	}

	public static void main(String[] args) {
		new ListOps();
	};

} // ListOps