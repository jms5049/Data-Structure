
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
				if (x <= (int) p.next.object) { // �������� �ڸ� ������ ������
					p.next = p.next.prev = new Node(x, p, p.next); // ��ĭ �տ� �������
					break;
				} else if (p.next.next == head) { // ���� ���ڵ麸�� Ŀ�� �� �������� �����ҋ�
					p = p.next; // p.next.next�� �ι��̵��� �Ͽ��� ������ p�� p.next�� ��ĭ �����Ŀ�
					head.prev = p.next = new Node(x, p, p.next); // �� ���� ����
					break;

				}
			}
		}
		size++;
	}

	public void delete(int x) {

		Node p = head;

		if (head.next == null) { //head�� ���� ��尡 ������
			System.out.println("D Linked List is Empty!"); //����ٰ� �޽��� ���
		} else {

			for (p = head; p != null; p = p.next) {  // �ɾ�ư��� p ��� ���� �� ������ �ɾ����.

				if (x == (int) p.next.object ) { // �Է� ���� �� x �� ���ٸ� ��带 ������

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