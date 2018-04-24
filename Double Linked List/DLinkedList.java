
public class DLinkedList {

	public Node head = new Node(null);
	private int size = 0;

	public void insert(int x) {

		System.out.print("insert  " + x + "\t | ");
		if (head.next.object == null) {
			head.prev = head.next = new Node(x, head, head);
		} else {
			Node p = head;
			for (p = head; p != null; p = p.next) {
				if (x <= (int) p.next.object) {
					p.next = p.next.prev = new Node(x, p, p.next);
					break;
				} else if (p.next.next == head) {
					p = p.next; 
					head.prev = p.next = new Node(x, p, p.next); 
					break;

				}
			}
		}
		size++;
	}

	public void delete(int x) {

		Node p = head;

		if (head.next == null) { 
			System.out.println("D Linked List is Empty!");
		} else {

			for (p = head; p != null; p = p.next) {  

				if (x == (int) p.next.object ) { 

					p.next = p.next.next;
					p = p.next.prev;
					System.out.print("delete  " + x + "\t | ");
					break;
				}
				
			}
			
		}
	

	--size;

	}

	public void print() {

		Node p = head;

		for (int i = 0; i < size; i++) {

			p = p.next;
			System.out.print(p.object + "<->");

		}

		System.out.println("null ");
	}

}
