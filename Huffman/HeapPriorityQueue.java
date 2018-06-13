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
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		if(!(object instanceof Comparable))
			throw new IllegalArgumentException();
		Comparable x = (Comparable)object;
		if(size == a.length)
 			resize();
		int i = size++;
		while(i>0){
			int j =i;
			i = (i-1)/2;
			if(a[i].compareTo(x)>=0){
				a[j] = x;
				return;
			}
			a[j] = a[i];
		}
		a[i]=x;
	}
	@Override
	public Object best() {
		// TODO Auto-generated method stub
		if(size==0)
 			throw new java.util.NoSuchElementException();
		return a[0];
	}
	@Override
	public Object removeBest() {
		// TODO Auto-generated method stub
		Object best = best();
		a[0] = a[--size];
		heapify(0,size);
		return best;
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}		
	
}