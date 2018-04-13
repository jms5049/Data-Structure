
public interface Queue {

	public void add(Object price, Object amount);
	public Object first();
	public Object remove();
	public int size();
	public void print();
	public void resize();
	
}