import java.util.Random;


public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//임의의 정수값을 산출하는 코드
		
		System.out.println("***** Insert LinkedList 1 *****");
		Random firstRandom = new Random();		
		LinkedList LinkedList1 = new LinkedList(); // LinkedList1 이라는 객체를 생성한다.	
		int size = 100; // 100 이내의 정수 중...	
		int i=0;
		while (i<10){
				int randomNumber = firstRandom.nextInt(size);
				LinkedList1.insert(randomNumber);			
				i++;
		}
		
		LinkedList1.print();				 // print 함수를 호출
		LinkedList1.reverse();		 		// reverse 함수를 호출
		System.out.println("***** Reverse LinkedList 1 *****");		
		LinkedList1.print();
		
		LinkedList LinkedList2 = new LinkedList();
		
		
			
		
		System.out.println("***** Insert LinkedList 2 *****");
		Random secondRandom = new Random();
		int range = 100; // 100 이내의 정수 중...
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
