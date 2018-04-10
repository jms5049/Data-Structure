import java.util.Random;

public class TestDLinkedList {
	public static DLinkedList list = new DLinkedList();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertDoublyLL();
		deleteDoublyLL();

	}
	
	public static void insertDoublyLL(){
		for(int i = 0; i < 10; i++){
			list.insert(new Random().nextInt(100));
			list.print();
		}
		
	}
	public static void deleteDoublyLL(){
		Node p = list.head;
		for(int i = 0; i<3; i++){
			Object deleteNumber = p.next.object;
			list.delete((int)deleteNumber);
			list.print();
		}
		
	}

}
