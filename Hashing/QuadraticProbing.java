
public class QuadraticProbing implements Map{

	private Entry[] entries;
	private int size, used, count;
	private float loadFactor;
	private final Entry NIL = new Entry(null, null);
	
	public QuadraticProbing(int capacity, float loadFactor){ 
		
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public QuadraticProbing(int capacity){ 
		
		this(capacity, 0.50F); 
	}
	
	public QuadraticProbing(){
		
		this(101);
	}
	
	
}
