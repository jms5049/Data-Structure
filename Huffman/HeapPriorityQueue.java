package huffmantree;public class HeapPriorityQueue implements PriorityQueue{
	private static final int CAPACITY = 100;
	private Comparable[] a;
	private int size;
	public HeapPriorityQueue(){
		this(CAPACITY);	
	}	
	public HeapPriorityQueue(int capacity) {
		// TODO Auto-generated constructor stub
		a = new Comparable[capacity];
	}
	
}