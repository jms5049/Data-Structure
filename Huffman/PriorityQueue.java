package huffmantree;
public interface PriorityQueue {
		public void add(Object object);
	//POSTCONDITION: the given object is in this Queue;
		public Object best();
	//RETURN: the highest priority element in this Queue;
	//PRECONDITION: this Queue is not empty;
		public Object removeBest();
	//RETURN: the highest priority element in this Queue;
	//PRECONDITION: this Queue is not empty;
	//POSTCONDITION: the returned object is not in this Queue;
		public int size();
	//RETURN: the number of elements in this Queue;
	}