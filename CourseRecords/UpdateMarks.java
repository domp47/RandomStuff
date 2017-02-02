package CourseRecords;

import java.io.Serializable;

import BasicIO.BasicForm;
import BasicIO.BinaryDataFile;

public class UpdateMarks implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7221016154167261678L;

	public UpdateMarks(){
		BinaryDataFile b = new BinaryDataFile();
	
		Course c = (Course) b.readObject();
		
		BasicForm bf = new BasicForm();
	}
}
