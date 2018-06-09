
public class SeparateChaining implements Map{
	
	private Entry[] entries;
	private int size, count;
	private float loadFactor;
	
	public SeparateChaining(int capacity, float loadFactor){
		entries = new Entry[capacity];
		this.loadFactor = loadFactor;
	}
	
	public SeparateChaining(int capacity){
		this(capacity, 075F);
	}
	
	public SeparateChaining(){
		this(101);
	}	

	

}
