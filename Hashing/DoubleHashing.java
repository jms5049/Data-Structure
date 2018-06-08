
public class DoubleHashing implements Map {

	private Entry[] entries;
	private int size, used, count;
	private float loadFactor;
	private final Entry NIL = new Entry(null, null);
	
	public DoubleHashing(int capacity, float loadFactor){ 
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public DoubleHashing(int capacity){ 
		
		this(capacity, 0.50F);
	}
	
	public DoubleHashing(){
		this(101);
	}
	
	

}

