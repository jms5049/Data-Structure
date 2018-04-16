import java.util.ArrayList;


public class ArrayStack extends ArrayList<Object>{
	int size = 0;
	
	
	public ArrayStack(){
		super();
		
	}
	
	public Object peek(){
	
		return get(size-1);
	}
	
	public Object pop(){
		
		size--;
		return remove(size);
		
	}
	
	public Object push(Object object){
	
		add(object);
		size ++;
		return null;
	}
	
	public int size(){
		return size;	
	}

}
