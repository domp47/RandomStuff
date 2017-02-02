package Assign5;

import java.io.Serializable;
import java.util.Iterator;

import BasicIO.BasicForm;
import BasicIO.BinaryDataFile;

public class BookImp implements Book, Serializable {

	private static final long serialVersionUID = -4380248419246151171L;
	private String isbn = "", name = "";
	private int nchap = 0;
	private int pages = 0;
	private double cost = 0;
	private int index = 0;

	private Chap[] chap;
	private Chap[] availChap;

	public BookImp() {

		BinaryDataFile in = new BinaryDataFile();
		int nbook = in.readInt();
		for (int i = 0; i < nbook; i++)
			in.readObject();

		int nachap = in.readInt();
		chap = new Chap[nachap];
		availChap = new Chap[chap.length];

		for (int i = 0; i < availChap.length; i++)
			availChap[i] = (Chap) in.readObject();

		BasicForm f = new BasicForm();
		f.addTextField("is", "Enter ISBN", 10);
		f.addTextField("ti", "Enter Title", 25);
		f.setTitle("New Book Information");

		f.accept();

		isbn = f.readString("is");
		name = f.readString("ti");

		f.close();

		BookCreateForm bcf = new BookCreateForm(this);
		NewChapForm cf = new NewChapForm(availChap);
		
		while (true) {
			cf.hide();
			bcf.show();
			bcf.update();

			if (bcf.getDone())
				break;

			bcf.hide();

			BasicForm fo = new BasicForm();
			fo.addTextField("", 0);
			fo.setEditable("", false);
			int but = fo.accept("Search for chapter", "Traverse chapters");
			fo.close();

			cf.show();

			if (but == 0) {
				Chap c = cf.find();

				if (c == null) {
					cf.notFound();
					continue;
				}
				
				if(!cf.confirm(c))
					continue;
				
				chap[index++] = c;
				
				if(pages!=0&&pages%2==0)
					pages+=c.getPages()+1;
				else
					pages+=c.getPages();
				cost+=(c.getPages()*c.getRoyalty())+(c.getPages()*0.25);
				nchap++;
				
				continue;
			}
			else{
				cf.resetIt();
				while(cf.hasNext()){
					
					Chap c = cf.nextChap();
					
					if(c==null)
						continue;
					else{
						
						chap[index++] = c;
						
						if(c.getPages()%2==0)
							pages+=c.getPages()+1;
						else
							pages+=c.getPages();
						cost+=(c.getPages()*c.getRoyalty())+(c.getPages()*0.25);
						nchap++;
						
						break;
					}
				}
			}
		}
		cf.close();
		bcf.close();
		
		new Catalogue(this);
	}

	@Override
	public Iterator<Chap> iterator() {
		return new ChapIterator(chap);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getISBN() {
		return isbn;
	}

	@Override
	public int getNumChap() {
		return nchap;
	}

	@Override
	public Chap getChap(String Ser) {
		for(int i = 0;i<chap.length;i++){
			if(chap[i].getSer().equals(Ser))
				return chap[i];
		}
		return null;
	}

	@Override
	public double getPrice() {
		return cost;
	}

	@Override
	public int getNumPages() {
		return pages;
	}
}
