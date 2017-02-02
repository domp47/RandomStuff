package CourseRecords;

import java.io.Serializable;
import BasicIO.*;

public class MarkingSchemeImpl implements MarkingScheme,Serializable{

	private static final long serialVersionUID = 528506337213243576L;
	private int numWork;
	private Work work[];
	
	public MarkingSchemeImpl(){
		BasicForm in;
		in = new BasicForm();		
		in.addTextField("input", "How many marks in the course?");
		in.accept("OK");
		numWork = in.readInt("input");
		in.close();
		
		work = new Work[numWork];
		
		MarkingSchemeForm f = new MarkingSchemeForm(this);		
		f.load();
		for(int i = 0;i<numWork;i++){
			work[i] = new WorkImpl(f.readName(i),f.readBase(i),f.readWeight(i));
		}
		
		f.close();
	}
	public int getNumWork() {
		return numWork;
	}

	@Override
	public String getName(int num) {
		return work[num].getName();
	}

	@Override
	public double getBase(int num) {
		return work[num].getBase();
	}

	@Override
	public double getWeight(int num) {
		return work[num].getWeight();
	}

	@Override
	public double apply(Student theStudent) {
		int sum = 0;
		double m;
		
		for(int i =0;i<numWork;i++){
			m = theStudent.getMark(i);
			
			if(m==-1)
				m = 0;
			sum+= ((m/getBase(i)) * (getWeight(i)));
		}
		
		return sum;
	}
	
}
