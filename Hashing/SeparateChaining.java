
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

	@Override
	public Object get(Object key) {
		// TODO Auto-generated method stub
		int h = hash(key);
		for(Entry e = entries[h]; e!=null; e = e.next){
			if(e.key.equals(key))
				return e.value; 
		}
		return null;
	}

	@Override
	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		int h = hash(key);
		for(Entry e = entries[h]; e!= null; e=e.next){
			if(e.key.equals(key)){
				Object oldValue = e.value;
				e.value = value;
				return oldValue; 
			}
		}
		entries[h] = new Entry(key, value, entries[h]);
		++size;
		if(size > loadFactor*entries.length)
			rehash();
		return null;
	}

	@Override
	public Object remove(Object key) {
		// TODO Auto-generated method stub
		int h = hash(key);
		for(Entry e = entries[h], prev = null; e!= null; prev = e, e= e.next){
			if(e.key.equals(key)){
				Object oldValue = e.value;
				if(prev == null)
					entries[h] = e.next;
				else
					prev.next = e.next;
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
		Entry next; 
		Entry(Object k, Object v, Entry n){
			key = k;
			value = v;
			next = n;
		}
	}			
	
	public int getCount(){
		return count;
	}
	
	private int hash(Object key){
		return (key.hashCode()&0x7FFFFFFF) % entries.length;
	}
	
	private void rehash(){
		Entry[] oldEntries = entries;
		entries = new Entry[2*oldEntries.length+1];
		for (int k = 0; k < oldEntries.length; k++){
			for(Entry old = oldEntries[k]; old != null;){
				Entry e = old;
				old = old.next;
				int h = hash(e.key);
				e.next = entries[h];
				entries[h] = e;
			}
		}
	}

}
