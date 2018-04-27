import java.util.Random;

public class LinkedList {
	
	Node start;

	class Node {
		private int x; 
		private Node next; 

		public Node(int x) {
			this.x = x;
		}
		private Node(int x, Node next) {
			this.x = x;
			this.next = next;
		}	
		
	}

	public void insert(int x) {

		if (start == null)
			;
		{
			start = new Node(x, start); 
		}
		
		Node p = start;
		
		while (p.next != null) { 
			p = p.next;

		}

		p = new Node(x, p.next); 
	}

	public void print() {
		
		Node p = start;
		while (p != null){
			System.out.print(p.x +"->");
			p = p.next;
		}
		System.out.println("null");
		
	}
	
	public void merge(LinkedList arg0) {

		Node p = null;
		for (p = start ; p.next != null ; p = p.next){
						 
			}
		 p.next = arg0.start;
		}
		
		
	
	public void reverse() {

		Node qPrevious  = null; 
		Node qNext;
		Node q = start;
		
		while(q != null){
			qNext=q.next; 
			q.next = qPrevious; 
			qPrevious = q; 
			q=qNext; 
			}	
			start = qPrevious;	
		
	}
}



