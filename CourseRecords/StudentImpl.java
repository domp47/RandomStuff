package CourseRecords;

import java.io.Serializable;

import BasicIO.*;

public class StudentImpl implements Student,Serializable{
	
	
	private static final long serialVersionUID = -6422497006934780166L;
	private String StudentNum;
	private String Name;
	private Course c;
	private double[] mark; 
	private double Fmark;
	
	public StudentImpl(ASCIIDataFile in,Course c){
		
		StudentNum = in.readString();
		Name = in.readString();
		mark = new double[c.getScheme().getNumWork()];
		this.c = c;
		
		for(int i = 0;i<mark.length;i++){
			mark[i] = -1;
		}
		
		Fmark = -1;
	}

	@Override
	public String getStNum() {
		return StudentNum;
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public double getMark(int num) {
		return mark[num];
	}

	@Override
	public double getFinalGrade() {
		return Fmark;
	}

	@Override
	public void calcFinalGrade() {
		Fmark = c.getScheme().apply(this);
	}

	@Override
	public void update() {
		StudentForm f = new StudentForm(this,c.getScheme());
		
		if(f.update()){
			for(int i = 0;i<mark.length;i++){
				mark[i] = f.readMark(i);
			}
			calcFinalGrade();
		}
		f.close();
	}
}
