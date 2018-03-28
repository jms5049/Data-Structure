import java.util.Random;

public class LinkedList {
	
	Node start; /* LinkedList ���� ���Ǵ� ���� */

	class Node {
		private int x; /* ��忡 ����Ǵ� ���� */
		private Node next; /* next ��� */

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
		{ // �ƹ��͵� �����Ǿ����� ������
			start = new Node(x, start); // ù ��带 �����Ѵ�

		}
		
		Node p = start; // �ɾ�ư��� ������ p�� ó�� �κп� ��ġ�Ѵ�.
		
		while (p.next != null) { // p�� ���� ��尡 ���� �Ѵٸ�
			p = p.next;// p = ���� ���� �ɾ��.

		}

		p = new Node(x, p.next); // p �� �ɾ� ���ư� ���� ��带 �����Ѵ�.

	}

	public void print() {
		
		Node p = start;
		while (p != null){
			System.out.print(p.x +"->");
			p = p.next;
		}
		System.out.println("null");
		/* ���� �ڵ� ���� */
	}
	
	public void merge(LinkedList arg0) {

		Node p = null;
		for (p = start ; p.next != null ; p = p.next){
						 
			}
		 p.next = arg0.start;
		}
		
		/* ���� �ڵ� ���� */
	
	public void reverse() {

		Node qPrevious  = null; // ���� ���� ��� (������  �Ŀ� ó���� �ɰ��̶� null�� �ʱ�ȭ)
		Node qNext; // ���� ���
		Node q = start; // ���� ��ġ ������
		
		while(q != null){
			qNext=q.next; //��ũ�帮��Ʈ�� ������ �ʱ� ���� �������� ��� ��Ƶ�
			q.next = qPrevious; // q�� ���� ���� ��带 ����Ŵ
			qPrevious = q; // ��ĭ �����ϱ� ���� ����1
			q=qNext; // ��ĭ �����ϱ� ���� ����2
			}	
			start = qPrevious;	
		
	}
}



