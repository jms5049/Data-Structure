import java.util.Random;

public class LinkedList {
	
	Node start; /* LinkedList 노드로 사용되는 변수 */

	class Node {
		private int x; /* 노드에 저장되는 정수 */
		private Node next; /* next 노드 */

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
		{ // 아무것도 생성되어잇지 않을때
			start = new Node(x, start); // 첫 노드를 생성한다

		}
		
		Node p = start; // 걸어나아가는 포인터 p가 처음 부분에 위치한다.
		
		while (p.next != null) { // p의 다음 노드가 존재 한다면
			p = p.next;// p = 다음 노드로 걸어간다.

		}

		p = new Node(x, p.next); // p 가 걸어 나아간 다음 노드를 생성한다.

	}

	public void print() {
		
		Node p = start;
		while (p != null){
			System.out.print(p.x +"->");
			p = p.next;
		}
		System.out.println("null");
		/* 내부 코드 구현 */
	}
	
	public void merge(LinkedList arg0) {

		Node p = null;
		for (p = start ; p.next != null ; p = p.next){
						 
			}
		 p.next = arg0.start;
		}
		
		/* 내부 코드 구현 */
	
	public void reverse() {

		Node qPrevious  = null; // 이전 왼쪽 노드 (리버스  후에 처음이 될곳이라 null로 초기화)
		Node qNext; // 다음 노드
		Node q = start; // 현재 위치 기준점
		
		while(q != null){
			qNext=q.next; //링크드리스트가 끊기지 않기 위해 다음노드룰 잠시 잡아둠
			q.next = qPrevious; // q가 이전 왼쪽 노드를 가르킴
			qPrevious = q; // 한칸 전진하기 위한 스텝1
			q=qNext; // 한칸 전진하기 위한 스텝2
			}	
			start = qPrevious;	
		
	}
}



