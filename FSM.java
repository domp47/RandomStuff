
//package FSM;

import BasicIO.*;

public class FSM {

	private int nState;
	private int[][] a;
	private boolean[] Fstate;

	public FSM(ASCIIDataFile in) {
		nState = in.readInt();

		Fstate = new boolean[nState];

		for (int i = 0; i < nState; i++) {
			if (in.readChar() == 'F')
				Fstate[i] = true;
		}

		a = new int[128][nState];

		for (int y = 0; y < a.length; y++) {
			for (int x = 0; x < a[y].length; x++) {
				a[y][x] = -1;
			}
		}

		while (true) {
			int cState = in.readInt();

			if (in.isEOF())
				break;

			int input = in.readChar();
			int nextState = in.readInt();

			a[input][cState] = nextState;
		}
	}; // constructor

	public String toString() {
		String s = "";

		for (int y = 0; y < 128; y++) {

			s += (char) y;

			for (int x = 0; x < nState; x++) {
				s += " " + a[y][x];
			}

			s += "\n";
		}

		for (int i = 0; i < 4; i++)
			System.out.println(Fstate[i]);

		return s;

	}; // toString

	public boolean recognize(String aString) {
		boolean valid = false;

		int c = 0, n;
		char i;

		for (int q = 0; q < aString.length(); q++) {
			i = aString.charAt(q);

			n = a[i][c];

			c = n;
			if (n == -1)
				break;

		}

		if (c == -1)
			valid = false;
		else if (Fstate[c] == true)
			valid = true;

		return valid;

	}; // recognize

} // FSM