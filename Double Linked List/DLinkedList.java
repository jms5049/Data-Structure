
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
				if (x <= (int) p.next.object) { // 넣으려는 자리 값보다 작을때
					p.next = p.next.prev = new Node(x, p, p.next); // 한칸 앞에 끼어넣음
					break;
				} else if (p.next.next == head) { // 그전 숫자들보다 커서 맨 마지막에 들어가야할떄
					p = p.next; // p.next.next로 두번이동을 하엿기 떄문에 p를 p.next로 한칸 전진후에
					head.prev = p.next = new Node(x, p, p.next); // 맨 끝에 붙임
					break;

				}
			}
		}
		size++;
	}

	public void delete(int x) {

		Node p = head;

		if (head.next == null) { //head의 다음 노드가 없으면
			System.out.println("D Linked List is Empty!"); //비었다고 메시지 출력
		} else {

			for (p = head; p != null; p = p.next) {  // 걸어나아가는 p 노드 생성 후 끝까지 걸어나간다.

				if (x == (int) p.next.object ) { // 입력 받은 값 x 와 같다면 노드를 지우자

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