package CourseRecords;

import java.io.Serializable;

public class WorkImpl implements Serializable, Work {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7576076810167889162L;
	private String name;
	private double base,wt;
	
	public WorkImpl(String n,double b,double w){
		name = n;
		base = b;
		wt = w;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public double getBase() {
		// TODO Auto-generated method stub
		return base;
	}
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return wt;
	}
	@Override
	public void setBase(double b) {
		// TODO Auto-generated method stub
		base = b;
	}
	@Override
	public void setWeight(double w) {
		// TODO Auto-generated method stub
		wt = w;
	}
}
