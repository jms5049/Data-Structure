
public class SlinkedQueue implements Queue {

	private Node front;
	private Node rear;
	private int size = 0;

	public class Node { // ���ο��� �ҷ������� private static ���� public���� �ٱ���
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
			System.out.print("ǰ��");
		} else {
			System.out.print("[" + first().price + "��  :" + first().amount + "��]");
			while (p.next != null) {

				System.out.print("<--" + "[" + p.next.price + "��  :" + p.next.amount + "��]");
				p = p.next;
			}

		}
		System.out.println();

	}

	@Override
	public void resize() { // ��ũ�帮��Ʈ������ �����ʴ´�.
		// TODO Auto-generated method stub

	}

}
