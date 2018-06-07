
public class LinearProbing implements Map{

	private Entry[] entries;
	private int size, used;
	private int count= 0;

	private float loadFactor;
	private final Entry NIL = new Entry(null, null);
	
	public LinearProbing(int capacity, float loadFactor){ 
		
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public LinearProbing(int capacity){ 
		
		this(capacity, 0.75F);
	}
	
	public LinearProbing(){
		
		this(101);
	}
	
	

}
