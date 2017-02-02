import BasicIO.*;

public class Marking {

	private ASCIIDataFile in;
	private ReportPrinter r;

	public Marking() {

		String name, course, tName, stNum;
		int nQuest,stu=0, nTries, pts, tP = 0;
		double avg;
		char[] ans;
		char[][] resp;
		boolean correct;

		in = new ASCIIDataFile();
		r = new ReportPrinter();

		course = in.readString();
		tName = in.readString();
		nQuest = in.readInt();

		setUpReport(course, tName);

		ans = new char[nQuest];
		resp = new char[4][nQuest];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = in.readChar();
		}

		while (true) {
			stNum = in.readString();
			r.writeString(stNum);

		if (in.isEOF()) break;

			stu++;
			
			name = in.readString();
			r.writeString(name);
			nTries = 0;
			pts = 0;
			correct = false;

			for (int y = 0; y < resp.length; y++) {
				for (int x = 0; x < resp[y].length; x++) {
					resp[y][x] = in.readChar();
				}
			}

			for (int x = 0; x < resp[0].length; x++) {
				nTries = 0;
				correct = false;
				for (int y = 0; y < resp.length; y++) {

					if (resp[y][x] == 'O' && y == (ans[x] - 'A'))
						correct = true;

					if (resp[y][x] == 'O')
						nTries++;
				}

				if (correct){
					pts += 4 - nTries;
					r.writeInt(4 - nTries);
				}
				else
					r.writeInt(0);
			}
			r.writeInt(pts);
			tP+=pts;
		}
		r.writeString("name", "Average");
		avg = tP / stu;
		r.writeDouble("mt", avg);
		
		in.close();
		r.close();
	}

	private void setUpReport(String c, String n) {

		r.setTitle(c, n);
		r.addField("stNum", "Student #", 6);
		r.addField("name", "Name", 20);
		r.addField("m1", "1", 2);
		r.addField("m2", "2", 2);
		r.addField("m3", "3", 2);
		r.addField("m4", "4", 2);
		r.addField("m5", "5", 2);
		r.addField("mt", "Mark", 4);

	}; // setUpReport

	public static void main(String[] args) {
		new Marking();
	}
}