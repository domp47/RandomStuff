package CourseRecords;

import BasicIO.*;

public class CourseTest {

	private Course aCourse; // course to test
	private String courseName; // course name
	private ASCIIDataFile from; // class list file

	public CourseTest() {

		from = new ASCIIDataFile();
		courseName = from.readString();
		aCourse = new CourseImpl(courseName, from);
		from.close();
		System.out.println("Course name: " + aCourse.getCourseName());
		System.out.println("Marking scheme: " + aCourse.getScheme());
		System.out.println("Number of students: " + aCourse.getNumStd());
		System.out.println("Course Average: " + aCourse.getCourseAve());
		System.out.println("Student 222222: " + aCourse.getStudent("222222").getName());
		System.out.println("Student 111111: " + aCourse.getStudent("111111").getName());
		System.out.println("Student 999999: " + aCourse.getStudent("999999"));
		for (Student aStd : aCourse) {
			aStd.update();
		}
		
		aCourse.calcFinalGrades();
		System.out.println("Course Average: " + aCourse.getCourseAve());
		for (Student aStd : aCourse) {
			System.out.println("Std: " + aStd.getStNum() + " Grade: " + aStd.getFinalGrade());
		}
		

	}; // constructor

	public static void main(String[] args) {
		new CourseTest();
		System.exit(0);
	};

} // CourseTest