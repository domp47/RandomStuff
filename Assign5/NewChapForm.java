package Assign5;

import BasicIO.BasicForm;

public class NewChapForm {
	
	BasicForm f = new BasicForm();
	Chap[] c;
	int index = 0;
	
	public NewChapForm(Chap[] c){
		this.c = c;
		
		f.setTitle("Chapter");
		f.addTextField("ser","Serial #",10);
		f.addTextField("ti","Tittle",25);
		f.setEditable("ti", false);
		f.addTextField("au","Author",25);
		f.setEditable("au", false);
		f.addTextField("p","Pages",4);
		f.setEditable("p", false);
		
	}
	public void resetIt(){
		index = 0;
	}
	public void notFound(){
		f.clearAll();
		f.writeString("ti", "Chapter not found");
		f.accept("Try Again");
	}
	public Chap find(){
		
		f.clearAll();
		
		f.accept("Find");
		
		String s = f.readString("ser");
		for(Chap ch:c){
			if(ch.getSer().equals(s))
					return ch;
		}
		return null;
	}
	public boolean confirm(Chap c){
		f.clearAll();
		fill(c);
		int button = f.accept("Confirm","Try Again");
		return button ==0;
	}
	public Chap nextChap(){
		if(index < c.length){
			fill(c[index++]);
		int but = f.accept("Add","Skip");
		
		if(but==0)
			return c[index-1];
		else 
			return null;
		}
		else 
			return null;
	}
	public boolean hasNext(){
		return index<c.length;
	}
	public void close(){
		f.close();
	}
	public void fill(Chap ch){
		f.writeString("ser", ch.getSer());
		f.writeString("ti", ch.getTit());
		f.writeString("au", ch.getAuth());
		f.writeDouble("p",ch.getPages());
	}
	public void hide(){
		f.hide();
	}
	public void show(){
		f.show();
	}
}
