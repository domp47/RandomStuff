package Assign5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChapIterator implements Iterator<Chap>{

	private Chap[] chap;
	private int index;
	
	ChapIterator(Chap[] c){
		chap = c;
		index = 0;
	}
	
	@Override
	public boolean hasNext() {
		return index < chap.length;
	}

	@Override
	public Chap next() {
		if ( ! hasNext() ) {
            throw new NoSuchElementException();
        };
        return chap[index++];
	}

}
