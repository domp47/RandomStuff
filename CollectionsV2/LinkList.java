package CollectionsV2;

public class LinkList<E> implements List<E> {

	Node<E> front;
	Node<E> cursor;
	Node<E> pre;
	int length;
	
	public LinkList(){
		front = new Node<E>(null,null);
		cursor = null;
		pre = front;
		length = 0;
	}
	
	@Override
	public void add(E item) {
		pre.next = new Node<E>(item,cursor);;
		cursor = pre.next;
		length+=1;
	}

	@Override
	public E remove() {
		
		if(cursor==null){
			throw new NoItemException();
		}
		else{
		E item;
		item = cursor.item;
		pre.next = cursor.next;
		length= length-1;;
		return item;
		}
	}

	@Override
	public E get() {
		if(cursor == null)
			throw new NoItemException();
		return cursor.item;
	}

	@Override
	public boolean empty() {
		return length==0;
	}

	@Override
	public int length() {
		return length;
	}

	@Override
	public void toFront() {
		pre = front;
		cursor = pre.next;
		
	}

	@Override
	public void advance() {
		if(cursor!=null){
			pre = cursor;
			cursor = cursor.next;
			
		}
		
	}

	@Override
	public boolean offEnd() {
		return cursor == null;
	}

}
