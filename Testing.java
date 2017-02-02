
public class Testing {
	public static void main(String[] args) {

		Node list,q,p;
		
		list = new Node(null, 5, null);
		p = list;
		for (int i = 4; i >= 1; i--) {
			p.prev = new Node(null, i, p);
			p = p.prev;
		}
		;
		list = p;
		
		p = list;
		
		while(p!=null){
			del(p);
			p=p.next;
		}
		
		p = list;
		
		while(p!= null){
			System.out.println(p.x);
			
			p = p.next;
		}
//		p = list.next.next.next.next;
//		while(p!= null){
//			System.out.println(p.x);
//			
//			p = p.prev;
//		}
		
	}
	private static void del(Node n){
		n= null;
	}
}
