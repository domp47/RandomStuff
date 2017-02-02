package lab11;
//package Rental;

import BasicIO.*;
import CollectionsV2.LinkList;
import CollectionsV2.List;

import static BasicIO.Formats.*;

public class Rental {

	ASCIIDataFile in;
	ASCIIDisplayer dis;
	BasicForm form;
	private List<Car> Avail,Rented;
	
	public Rental() {
		in = new ASCIIDataFile("C:\\Users\\Domenic\\Desktop\\cars.txt");
		form = new BasicForm();

		setupForm();
		form.hide();

		boolean quit = false;
		int but,choice;
		Car c;
		String plate;
		
		Avail = load(in);
		Rented = new LinkList<Car>();

		form.show();
		while (!quit) {
			form.clearAll();

			but = form.accept("Rent", "Return", "List", "Quit");

			switch (but) {
			case 0:
				if (!Avail.empty()) {
					
					form.writeString("msg", "Choose Preferred Category.");
					form.accept();
					choice = form.readInt("cat");
					
					Avail.toFront();
					
					while(!Avail.empty()){
						if(Avail.get().getCategory()==choice)
							break;
						Avail.advance();
					}
					if(Avail.offEnd()){
						form.writeString("msg", "Sorry, No cars Available.");
						form.accept("OK");
						break;
					}
					
					form.writeString("licence", Avail.get().getLicence());
					form.writeInt("oMileage", Avail.get().getMileage());
					form.writeInt("cat", Avail.get().getCategory());
					form.writeDouble("rate", Avail.get().getRate());
					form.writeString("msg", "Rented: " + Avail.get().getLicence());

					c = Avail.get();
					Avail.remove();
					addRent(c);
				} else
					form.writeString("msg", "Sorry, No cars Available.");

				form.accept("OK");
				break;
			case 1:
				if (!Rented.empty()) {
					form.writeString("msg", "Enter Licence Plate of Vehicle Returning.");
					form.accept("OK");
					plate = form.readString("licence");

					Rented.toFront();
					
					while(!Rented.offEnd()){
						if(Rented.get().getLicence().equals(plate.toUpperCase()))
							break;
						Rented.advance();
					}
					if(Rented.offEnd()){
						form.writeString("msg", "Sorry, Car not Found.");
						form.accept("OK");
						break;
					}
					form.writeString("licence", Rented.get().getLicence());
					form.writeInt("oMileage", Rented.get().getMileage());
					form.writeInt("cat", Rented.get().getCategory());
					form.writeDouble("rate", Rented.get().getRate());
					form.writeString("msg", "Rented: " + Rented.get().getLicence());
					form.accept("OK");
					if(Rented.get().getMileage()<form.readInt("nMileage"))
					form.writeDouble("amt", Rented.get().returned(form.readInt("nMileage")));
					form.writeString("msg", "Returned: " + form.readString("licence"));
					form.accept("OK");

					c = Rented.get();
					Rented.remove();
					addAvail(c);

				} else {
					form.writeString("msg", "No Cars to Return Right Now.");
					form.accept("OK");
				}

				break;
			case 2:
				form.hide();
				dis = new ASCIIDisplayer();
				dis.writeString("Available\n");
				listA();
				dis.writeString("Rented\n");
				listR();
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

	private void listA() {
		Avail.toFront();
		
		while (!Avail.offEnd()) {
			dis.writeLine(Avail.get().getLicence() + ": " + Avail.get().getMileage() + ", " + Avail.get().getCategory());
			dis.newLine();

			Avail.advance();
		}
	}

	private void listR() {
		
		Rented.toFront();
		
		while (!Rented.offEnd()) {
			dis.writeLine(Rented.get().getLicence() + ": " + Rented.get().getMileage() + ", " + Rented.get().getCategory());
			dis.newLine();

			Rented.advance();
		}
	}

//	private removeAvail(String lic) {
//		Node q=null;
//		Node p = Avail;
//		while(p!=null&&re.item!=p.item){
//			q=p;
//			p=p.next;
//		}
//		if(p!=null){
//			if(q==null)
//				Avail = p.next;
//			else
//				q.next=p.next;
//		}
//		return Avail;
//	}
//
//	private Car removeRent(String lic) {
//		Car c;
//		
//		Rented.toFront();
//		while(!Rented.offEnd()&&Rented.get().getLicence().compareTo(lic)==0)
//			Rented.advance();
//		return Rented;
//	}

	private void addAvail(Car c) {
		
		Avail.toFront();
		
		while(!Avail.offEnd()&&c.getMileage()>=Avail.get().getMileage()){
			Avail.advance();
		}
		Avail.add(c);
	}

	private void addRent(Car c) {
		Rented.toFront();
		Rented.add(c);
	}

	private List<Car> load(ASCIIDataFile in) {
		List<Car> l = new LinkList<Car>();
		Car c;

		l.add(new Car(in));

		while (true) {
			c = new Car(in);
			if (in.isEOF())
				break;

			l.add(c);
		}

		return l;
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