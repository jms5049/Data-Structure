import java.util.Random;


public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//������ �������� �����ϴ� �ڵ�
		
		System.out.println("***** Insert LinkedList 1 *****");
		Random firstRandom = new Random();		
		LinkedList LinkedList1 = new LinkedList(); // LinkedList1 �̶�� ��ü�� �����Ѵ�.	
		int size = 100; // 100 �̳��� ���� ��...	
		int i=0;
		while (i<10){
				int randomNumber = firstRandom.nextInt(size);
				LinkedList1.insert(randomNumber);			
				i++;
		}
		
		LinkedList1.print();				 // print �Լ��� ȣ��
		LinkedList1.reverse();		 		// reverse �Լ��� ȣ��
		System.out.println("***** Reverse LinkedList 1 *****");		
		LinkedList1.print();
		
		LinkedList LinkedList2 = new LinkedList();
		
		
			
		
		System.out.println("***** Insert LinkedList 2 *****");
		Random secondRandom = new Random();
		int range = 100; // 100 �̳��� ���� ��...
		int j=0;
		while (j<10){
				int secondrandomNumber = secondRandom.nextInt(size);
				LinkedList2.insert(secondrandomNumber);
				j++;
		}
			
		LinkedList2.print();
		
		
		LinkedList1.merge(LinkedList2);
		System.out.println("***** Merge LinkedList 1&2 *****");
		LinkedList1.print();
		
		
		
	}

}
