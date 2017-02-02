package CourseRecords;

import java.io.*;
import java.util.Iterator;
import BasicIO.*;

public class CourseImpl implements Course,Serializable{
	
	private static final long serialVersionUID = -4774503933443895653L;
	private String CourseName;
	private MarkingScheme ms;
	private Student[] stu;
	private int numOfStu;
	private double ave = -1;
	
	public CourseImpl(String cn,ASCIIDataFile in){
		CourseName = cn;
		ms = new MarkingSchemeImpl();
		
		numOfStu = in.readInt();
		stu = new Student[numOfStu];
		
		for(int i = 0;i<stu.length;i++){
			stu[i] = new StudentImpl(in,this);
		}
	}

	@Override
	public Iterator<Student> iterator() {
		return new CourseIterator(stu);
	}

	@Override
	public String getCourseName() {
		return CourseName;
	}

	@Override
	public MarkingScheme getScheme() {
		return ms;
	}

	@Override
	public int getNumStd() {
		return numOfStu;
	}

	@Override
	public double getCourseAve() {
		return ave;
	}

	@Override
	public Student getStudent(String stNum) {
		
		for(int i = 0;i<stu.length;i++){
			if(stu[i].getStNum().equals(stNum))
				return stu[i];
		}
		
		return null;
	}

	@Override
	public void calcFinalGrades() {
		double sum = 0;
		
		for(int i = 0;i<stu.length;i++){
			stu[i].calcFinalGrade();
			sum+=stu[i].getFinalGrade();
		}
		System.out.println(sum);
		sum/=numOfStu;
		
		ave = sum;		
	}
}
