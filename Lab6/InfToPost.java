package Lab6;

import CharStacks.*;
import BasicIO.*;

/**
 * This class is a program to perform infix to postfix conversion. It
 * consecutively reads strings representing infix expressions and then produces
 * and displays the equivalent postfix expression. The process involves a stack
 * of characters.
 *
 * @see CharStack
 * @see ConCharStack
 *
 * @author your name
 *
 * @version 1.0 (Feb. 2015)
 */

public class InfToPost {

	private BasicForm dis; // form for UI
	private CharStack cs;
	private CharStack ncs;

	/**
	 * The constructor repeatedly reads infix expressions, converts them to
	 * postfix and displays them.
	 */

	public InfToPost() {
		boolean quit = false;
		String inf;
		int but;

		dis = new BasicForm();

		buildForm();

		while (!quit) {
			but = dis.accept("Convert", "Clear", "Quit");
			inf = dis.readString("infix");

			if (but == 0)
				dis.writeString("postfix", translate(inf));
			else if (but == 1)
				dis.clearAll();
			else
				quit = true;
		}

		dis.close();
	}; // constructor

	/** This method builds the form for expression string IO. */

	private void buildForm() {

		dis.setTitle("Infix to Postfix");
		dis.addTextField("infix", "Infix");
		dis.addTextField("postfix", "Postfix");

	}; // buildForm

	/**
	 * This method does the actual conversion from infix to postfix. It
	 * concatenates a dummy operator to the end of the input string and then
	 * processes the string from left to right, placing operands into the output
	 * string and pushing or popping operators to a stack depending on their
	 * relative priorities.
	 *
	 * @param in
	 *            the infix expression to be converted.
	 *
	 * @return String the equivalent postfix expression.
	 */

	private String translate(String in) {
		in += "#";
		String s = "";
		char[] inElt = in.toCharArray();
		cs = new ConCharStack(in.length() + 1);
		cs.push('$');

		for (char ch: inElt) {
			if (ch == 42 | ch == 43 | ch == 45 | ch== 47 | ch == 35) {

				while(prio(cs.top())>= prio(ch)){
					s+=cs.pop();
				}
				cs.push(ch);
				if(ch==35)
					break;
			}
			else if(ch == 40){
				cs.push(ch);
			}
			else if(ch == 41){
				s+=cs.pop();
			}
			else {
				s += (ch);
			}
		}
		return s;

	}; // translate

	/**
	 * This method returns the relative priority of an operator.
	 *
	 * @param c
	 *            the operator
	 *
	 * @return int the relative priority of c.
	 */

	private int prio(char c) {
		switch (c) {
		case 42:
			return 3;
		case 47:
			return 3;
		case 43:
			return 2;
		case 45:
			return 2;
		case 35:
			return 1;
		case 36:
			return 0;
		default:
			return 0;
		}
	}; // prio

	public static void main(String[] args) {
		new InfToPost();
	};

} // InfToPost