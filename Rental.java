//package Rental;

import BasicIO.*;
import static BasicIO.Formats.*;

public class Rental {

	ASCIIDataFile in;
	ASCIIDisplayer dis;
	BasicForm form;

	public Rental() {
		in = new ASCIIDataFile("C:\\Users\\Domenic\\Desktop\\cars.txt");
		form = new BasicForm();

		setupForm();
		form.hide();

		Node Avail, Rented,p;
		boolean quit = false;
		int but,choice;
		Car c;
		String plate;
		
		Avail = load(in);
		Rented = null;

		form.show();
		while (!quit) {
			form.clearAll();

			but = form.accept("Rent", "Return", "List", "Quit");

			switch (but) {
			case 0:
				if (Avail != null) {
					
					form.writeString("msg", "Choose Preferred Category.");
					form.accept();
					choice = form.readInt("cat");
					
					p = Avail;
					
					while(p != null){
						if(p.item.getCategory()==choice)
							break;
						p=p.next;
					}
					if(p == null){
						form.writeString("msg", "Sorry, No cars Available.");
						form.accept("OK");
						break;
					}
					
					form.writeString("licence", p.item.getLicence());
					form.writeInt("oMileage", p.item.getMileage());
					form.writeInt("cat", p.item.getCategory());
					form.writeDouble("rate", p.item.getRate());
					form.writeString("msg", "Rented: " + p.item.getLicence());

					c = p.item;
					Avail = removeAvail(Avail,p);
					Rented = addRent(c, Rented);
				} else
					form.writeString("msg", "Sorry, No cars Available.");

				form.accept("OK");
				break;
			case 1:
				if (Rented != null) {
					form.writeString("msg", "Enter Licence Plate of Vehicle Returning.");
					form.accept("OK");
					plate = form.readString("licence");
					
					p = Rented;
					while(p != null){
						if(p.item.getLicence().equals(plate.toUpperCase()))
							break;
						p=p.next;
					}
					if(p == null){
						form.writeString("msg", "Sorry, Car not Found.");
						form.accept("OK");
						break;
					}
					form.writeString("licence", p.item.getLicence());
					form.writeInt("oMileage", p.item.getMileage());
					form.writeInt("cat", p.item.getCategory());
					form.writeDouble("rate", p.item.getRate());
					form.writeString("msg", "Rented: " + p.item.getLicence());
					form.accept("OK");
					if(p.item.getMileage()<form.readInt("nMileage"))
					form.writeDouble("amt", p.item.returned(form.readInt("nMileage")));
					form.writeString("msg", "Returned: " + form.readString("licence"));
					form.accept("OK");

					c = p.item;
					Rented = removeRent(Rented,p);
					Avail = addAvail(c, Avail);

				} else {
					form.writeString("msg", "No Cars to Return Right Now.");
					form.accept("OK");
				}

				break;
			case 2:
				form.hide();
				dis = new ASCIIDisplayer();
				dis.writeString("Available\n");
				listA(Avail);
				dis.writeString("Rented\n");
				listR(Rented);
				dis.close();
				form.show();
				break;
			case 3:
				quit = true;
				break;

			}
		}
		form.close();
		in.close();

	}

	private void listA(Node p) {
		while (p != null) {
			dis.writeLine(p.item.getLicence() + ": " + p.item.getMileage() + ", " + p.item.getCategory());
			dis.newLine();

			p = p.next;
		}
	}

	private void listR(Node q) {
		while (q != null) {
			dis.writeLine(q.item.getLicence() + ": " + q.item.getMileage() + ", " + q.item.getCategory());
			dis.newLine();

			q = q.next;
		}
	}

	private Node removeAvail(Node Avail,Node re) {
		Node q=null;
		Node p = Avail;
		while(p!=null&&re.item!=p.item){
			q=p;
			p=p.next;
		}
		if(p!=null){
			if(q==null)
				Avail = p.next;
			else
				q.next=p.next;
		}
		return Avail;
	}

	private Node removeRent(Node Rented,Node re) {
		Node q=null;
		Node p = Rented;
		while(p!=null&&re.item!=p.item){
			q=p;
			p=p.next;
		}
		if(p!=null){
			if(q==null)
				Rented = p.next;
			else
				q.next=p.next;
		}
		return Rented;
	}

	private Node addAvail(Car c, Node Avail) {
		Node p = Avail;
		
		while(p.next!=null){
			p=p.next;
		}
		p.next = new Node(c,null);

		return Avail;
	}

	private Node addRent(Car c, Node Rented) {
		Node p = new Node(c, Rented);

		return p;
	}

	private Node load(ASCIIDataFile in) {
		Node p;
		Car c;

		p = new Node(new Car(in), null);

		while (true) {
			c = new Car(in);
			if (in.isEOF())
				break;

			p = new Node(c, p);
		}

		return p;
	}

	private void setupForm() {

		form.setTitle("Acme Rentals");
		form.addTextField("licence", "Licence", 8, 10, 10);
		form.addRadioButtons("cat", "Category", true, 10, 40, Car.CAT);
		form.addTextField("rate", "Rate", getCurrencyInstance(), 8, 294, 40);
		form.setEditable("rate", false);
		form.addTextField("oMileage", "Rental Mileage", getIntegerInstance(), 8, 10, 160);
		form.setEditable("oMileage", false);
		form.addTextField("nMileage", "Returned Mileage", getIntegerInstance(), 8, 222, 160);
		form.addTextField("amt", "Amount", getCurrencyInstance(), 10, 10, 190);
		form.setEditable("amt", false);
		form.addTextField("msg", "Message", 45, 10, 220);
		form.setEditable("msg", false);

	}; // setupForm

	public static void main(String[] args) {
		new Rental();
	}

}