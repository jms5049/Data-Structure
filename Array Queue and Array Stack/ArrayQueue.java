import java.util.ArrayList;


public class ArrayQueue extends ArrayList<Object>{
	int size = 0;
	
	
	
	public ArrayQueue(){
		super();
	}
	
	public Object first(){

		return get(size);
	}
	
	public Object deQueue(){
		
		return remove(0);
	}
	
	public Object addQueue(Object object){
		add(object);
		size ++;
		return null;
	}
	
	public int size(){
		return size;
	}

}
