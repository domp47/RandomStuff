package CourseRecords;

import java.io.Serializable;

import BasicIO.*;

/**
 * This class is is a program to set up a new course offering.
 *
 * @see Course
 * @see Student
 * @see MarkingScheme
 *
 * @author D. Hughes
 *
 * @version 1.0 (Jan. 2014)
 */

public class NewCourse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2291248416018684854L;
	private BinaryOutputFile courseData; // input file for course data

	/**
	 * The constructor sets up a new course reading course information from a
	 * class list file.
	 */

	public NewCourse() {

		ASCIIDataFile classList; // file for class list
		String courseName; // name of course
		BasicForm form; // form for create check
		CourseForm cForm; // form for course display
		Course aCourse; // course being processed
		int button; // button pressed

		classList = new ASCIIDataFile();
		courseName = classList.readString();
		form = new BasicForm();
		form.addLabel("msg", "Create course: " + courseName);
		button = form.accept("Create", "Cancel");
		form.close();
		if (button == 0) {
			aCourse = new CourseImpl(courseName, classList);
			classList.close();
			cForm = new CourseForm(aCourse);
			cForm.display();
			cForm.close();
			courseData = new BinaryOutputFile();
			courseData.writeObject(aCourse);
			courseData.close();
		}
	} // constructor

	public static void main(String[] args) {
		new NewCourse();
		System.exit(0);
	}

} // newCourse
