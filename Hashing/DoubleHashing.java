
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
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		
		int h = hash(key);
		int d = hash2(key);
		for(int i = 0; i < entries.length; i++){
			int j = doubleHash(h,d,i);
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
		int d = hash2(key);
		for(int i = 0; i < entries.length; i++){
			int j = doubleHash(h,d,i);
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
		int d = hash2(key);
		for (int i = 0; i<entries.length; i++){
			int j = doubleHash(h,d,i);
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
	
	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		
		int h = hash(key);
		int d = hash2(key);
		for(int i = 0; i < entries.length; i++){
			int j = doubleHash(h,d,i);
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
		int d = hash2(key);
		for(int i = 0; i < entries.length; i++){
			int j = doubleHash(h,d,i);
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
		int d = hash2(key);
		for (int i = 0; i<entries.length; i++){
			int j = doubleHash(h,d,i);
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
	
	private class Entry{
		Object key, value;
		Entry(Object k, Object v){
			key = k;
			value = v;
		}
	}
	
	private int doubleHash(int h,int d, int i){
		return (h+i*d)%entries.length;
	}
	
	public int getCount(){
		return count;
	}
	
	private int hash(Object key){
		return (key.hashCode()&0x7FFFFFFF) % entries.length;
	}
	
	private int hash2(Object key){
		return 1+((key.hashCode()&0x07FFFFFFF) % (entries.length-1));
	}
	
	private void rehash(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for(int k = 0; k < oldEntries.length; k++){
			Entry entry = oldEntries[k];
			if (entry == null || entry == NIL)
				continue;
			int h = hash(entry.key);
			int d = hash2(entry.key);
			for(int i = 0; i < entries.length; i++){
				int j = doubleHash(h,d,i);
				if(entries[j] == null){
					entries[j] = entry;
					break;
				}
			}
		}
		used = size;		
	}	
	
}

