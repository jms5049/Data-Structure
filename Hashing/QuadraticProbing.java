
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
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		
		
		int h = hash(key);
		for(int i = 0; i < entries.length; i++){
			int j = quadraticProbe(h,i);
			Entry entry = entries[j];
			if(entry == null)
				
				break;
			if(entry == NIL)
				
				continue;
			if(entry.key.equals(key))
				
				return entry.value;
		}
		return null; 
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		
		
		if(used > loadFactor*entries.length)
			
			rehash();
		int h = hash(key);
		for(int i = 0; i < entries.length; i++){
			int j = quadraticProbe(h,i);
			
			Entry entry = entries[j];
			if(entry == null){
				
				entries[j] = new Entry(key, value);
				++size;
				++used;
				return null;
			}			
			
			if(entry == NIL)				
				continue;

			if(entry.key.equals(key)){
				
				Object oldValue = entry.value;
				entries[j].value = value;	
				
				return oldValue;					
			}		
			count++;
		}
		return null; 
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		
		
		int h = hash(key);
		for (int i = 0; i<entries.length; i++){
			int j = quadraticProbe(h,i);
			Entry entry = entries[j];
			if(entry == null)
				
				break;
			if(entry == NIL)
				continue;
			if(entry.key.equals(key)){
				Object oldValue = entry.value;
				entries[j] = NIL;
				--size;
				return oldValue;
			}
		}
		return null; 
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	
}
