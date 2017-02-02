package CourseRecords;

import java.io.Serializable;

import BasicIO.BinaryDataFile;
import BasicIO.BinaryOutputFile;

public class RecordMarks implements Serializable{
	
	private static final long serialVersionUID = -8192492125252279875L;
	private BinaryDataFile bf;

	private RecordMarks(){
		bf = new BinaryDataFile();
		
		Course c = (Course) bf.readObject();
		
		bf.close();
		
		CourseForm cf = new CourseForm(c);
		
		if(cf.confirm()){
			for(Student s:c){
				s.update();
			}
		}
		else
			return;
		BinaryOutputFile out = new BinaryOutputFile();
		
		out.writeObject(c);
		
		out.close();
	}
	public static void main(String[] args){
		new RecordMarks();
		System.exit(0);
	}
}
