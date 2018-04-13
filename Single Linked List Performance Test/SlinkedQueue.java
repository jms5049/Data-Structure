
public class SlinkedQueue implements Queue {

	private Node front;
	private Node rear;
	private int size = 0;

	public class Node { // 메인에서 불러오려면 private static 말고 public으로 바까줌
		Object price;
		Object amount;
		Node next;

		Node(Object price, Object amount) {
			this.price = price;
			this.amount = amount;
		}

		Node(Object price, Object amount, Node next) {
			this.price = price;
			this.amount = amount;
			this.next = next;
		}

	}

	@Override
	public void add(Object price, Object amount) {
		// TODO Auto-generated method stub

		if (front == null) {
			front = rear = new Node(price, amount, null);
			print();
		} else {

			rear.next = new Node(price, amount, null);
			rear = rear.next;
			print();

		}
		size++;

	}

	@Override
	public Node first() {
		// TODO Auto-generated method stub
		return front;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub

		if (front == null) {
			System.out.println("Queue is Empty");
		} else {

			front = front.next;
			size--;
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

		if (front == null) {
			System.out.print("품절");
		} else {
			System.out.print("[" + first().price + "원  :" + first().amount + "개]");
			while (p.next != null) {

				System.out.print("<--" + "[" + p.next.price + "원  :" + p.next.amount + "개]");
				p = p.next;
			}

		}
		System.out.println();

	}

	@Override
	public void resize() { // 링크드리스트에서는 쓰지않는다.
		// TODO Auto-generated method stub

	}

}
