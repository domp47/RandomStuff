package Collections;

import java.io.Serializable;

public class LnkQueue<E> implements Queue<E>, Serializable{

	private static final long serialVersionUID = -4379690413072452890L;
	private Node<E> front,rear;
	private int count;
	
	
	public LnkQueue(){
		front = null;
		rear = front;
		count = 0;
	}
	
	@Override
	public void enter(E item) {
		if(empty()){
			front = new Node<E>(item, null);
			rear = front;
			count = 1;
		}else{
		rear.next = new Node<E>(item, null);
		rear = rear.next;
		count++;
		}
	}

	@Override
	public E leave() {
		
		E e = (E) front.item;
		front = front.next;
		count--;
		return e;
	}

	@Override
	public E front() {
		if ( count <= 0 ) {
            throw new NoItemException();
        }
        else {
            return front.item;
        }
	}

	@Override
	public boolean empty() {
		return(count <= 0);
	}

	@Override
	public int length() {
		return count;
	}

}
