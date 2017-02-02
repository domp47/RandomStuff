
//package Billing;

import BasicIO.*;
import static BasicIO.Formats.*;

public class Update {

	/* Instance Variables */
	private BasicForm usageForm; // meter reading form
	private ASCIIDataFile in;
	private ASCIIOutputFile out;

	public Update() {
		Account[] acct = new Account[4];
		Account a;
		int but;
		in = new ASCIIDataFile();
		out = new ASCIIOutputFile();
		usageForm = new BasicForm();

		loadAccts(acct);
		setUpForm();

		while (true) {
			usageForm.clearAll();
			but = usageForm.accept("Find", "Quit");

			if (but == 0) {
				a = findAcct(usageForm.readString("acctNum"), acct);

				if (a == null) {
					usageForm.writeString("name", "Account Not Found.");
					usageForm.accept("Try Again");
					usageForm.clearAll();
				} else {
					fillForm(a);

					but = usageForm.accept("Update", "Quit");

					if (but == 0) {
						a.takeReading(usageForm.readDouble("reading"));
					} else
						break;
				}
			} else if (but == 1)
				break;
		}

		writeAccts(acct);

		in.close();
		usageForm.close();

	}; // construtor

	private void loadAccts(Account[] acct) {
		for (int i = 0; i < acct.length; i++) {
			acct[i] = new Account(in);
			if (in.isEOF())
				break;
		}

	}; // loadAccts

	private void writeAccts(Account[] acct) {
		for (int i = 0; i < acct.length; i++) {
			if (acct[i] == null)
				break;
			out.writeString(acct[i].getAcctNum());
			out.writeString(acct[i].getName());
			out.writeDouble(acct[i].getPrevReading());
			out.writeDouble(acct[i].getCurrReading());
			out.newLine();
		}

	}; // writeAccts

	private Account findAcct(String acctNum, Account[] acct) {
		Account a = null;

		int l, h, p;

		l = 0;
		h = acct.length - 1;

		while (l <= h) {
			p = (l + h) / 2;

			if (acctNum.compareTo(acct[p].getAcctNum()) == 0)
				return acct[p];
			if (acctNum.compareTo(acct[p].getAcctNum()) > 0)
				l = p + 1;
			else
				h = p - 1;

		}

		// for (int i = 0; i < acct.length; i++) {
		// if (acct[i].getAcctNum().equals(acctNum))
		// return acct[i];
		// if (acct[i] == null)
		// break;
		// }

		return a;
	}; // findAcct

	private void setUpForm() {

		usageForm.setTitle("Over The Horizon Utilities");
		usageForm.addTextField("acctNum", "Account #", getIntegerInstance(), 6, 10, 10);
		usageForm.addTextField("name", "Name", 20, 10, 40);
		usageForm.addTextField("prev", "Previous Reading", getDecimalInstance(1), 6, 10, 70);
		usageForm.addTextField("reading", "Current Reading", getDecimalInstance(1), 6, 10, 100);

	}; // setUpForm

	private void fillForm(Account anAcct) {
		usageForm.writeString("acctNum", anAcct.getAcctNum());
		usageForm.writeString("name", anAcct.getName());
		usageForm.writeDouble("prev", anAcct.getPrevReading());

	}; // fillForm

	public static void main(String[] args) {
		new Update();
	};

} // Update