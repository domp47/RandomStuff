package CourseRecords;

import java.io.Serializable;

import BasicIO.BinaryDataFile;

public class MarksList implements Serializable {

	private static final long serialVersionUID = -3319125614606930826L;
	private BinaryDataFile bf;
	private CourseForm cForm;
	private MarkReport mr;

	public MarksList() {
		bf = new BinaryDataFile();

		Course c = (Course) bf.readObject();
		bf.close();

		cForm = new CourseForm(c);
		cForm.display();
		cForm.close();

		mr = new MarkReport(c);

		for (Student s : c) {
			mr.writeDetailLine(s);
		}
		mr.writeSummary();
		mr.close();
	}

	public static void main(String[] args) {
		new MarksList();
		// System.exit(0);
	}

}
