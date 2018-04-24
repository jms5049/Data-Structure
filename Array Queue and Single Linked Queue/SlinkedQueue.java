
public class SlinkedQueue implements Queue {

	private Node front;
	private Node rear;
	private int size = 0;	
	
	private static class Node {
		Object object;
		Node next;

		Node(Object object) {
			this.object = object;
		}

		Node(Object object, Node next) {
			this.object = object;
			this.next = next;
		}

	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		
		if(front == null){
			front = rear = new Node ( object , null);
			System.out.print("ADD        " + object + " | ");
			print();
		}
		else{
			System.out.print("ADD        " + object + " | ");
			rear.next = new Node ( object , null);
			rear = rear.next;
			print();
			
		}
		size ++;

	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return front.object;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		
		Object temp = null;
		
		if(front==null){
			System.out.println("LinkedList Queue is Empty");
		}
		else {
			System.out.print("REMOVE     " + first() + " | ");
			temp = front.object; 
			front = front.next;
			size--;
			print();
		}
		
		
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		Node p = front;
		
		if(front == null){
			System.out.print("null");
		}
		else {
			System.out.print(first());
			while (p.next != null){

				System.out.print("<--" + p.next.object);
				p = p.next;
			}
			System.out.print("<--null");

		}
		System.out.println();

	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub

	}

}
