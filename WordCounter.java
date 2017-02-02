import BasicIO.*;

public class WordCounter {

	private ASCIIDisplayer d;

	public WordCounter() {
		WordReader wr = new WordReader();

		wNode list = null, p, sortedList;
		String word;

		while (true) {
			word = wr.readWord();
			if (wr.isEOF())
				break;

			p = list;
			while (p != null) {
				if (word.equalsIgnoreCase(p.w.getWord()))
					break;

				p = p.next;
			}

			if (p == null) {
				list = new wNode(new Word(word), list);
			} else {
				p.w.addIt();
			}
		}

		d = new ASCIIDisplayer();
		
		sortedList = Sort(list);

		writeTo(sortedList);

		d.close();
		wr.close();
	}

	public void writeTo(wNode list) {
		wNode p = list;

		while (p != null) {
			d.writeString(p.w.getIt() + " " + p.w.getWord());
			d.newLine();

			p = p.next;
		}
	}

	public wNode Sort(wNode list) {
		wNode sorted, p, q, r;
		p = list;

		sorted = new wNode(p.w, null);
		p = p.next;

		if (p.w.getIt() < sorted.w.getIt()) {
			sorted.next = new wNode(p.w, null);
		} else {
			sorted = new wNode(p.w, sorted);
		}

		p = p.next;

		while (p != null) {
			q = sorted;
			r = sorted.next;

			if (p.w.getIt() > q.w.getIt())
				sorted = new wNode(p.w, sorted);
			else {
				while (r != null) {
					if (q.w.getIt() >= p.w.getIt() & p.w.getIt() >= r.w.getIt()) {
						q.next = new wNode(p.w, r);
						break;
					} else {
						q = r;
						r = r.next;
					}

				}
				if (r == null) {
					q.next = new wNode(p.w, null);
				}
			}

			p = p.next;
		}
		return sorted;
	}

	public static void main(String[] args) {
		new WordCounter();
	}
}
