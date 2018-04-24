public class ArrayQueue implements Queue {
	Object queue[];
	int size;
	int queueSize;

	public ArrayQueue(int queueSize) {
		this.queue = new Object[queueSize];
		this.queueSize = queueSize;
		this.size = 0;
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		queue[size] = object;
		size++;

		if (size > queueSize) { 
			System.out.println("Array Queue is Full! RESIZE");
		}
		if (size == queueSize) { 

			resize();
		} else {
			System.out.print("ADD        " + object + " | ");
			print();
		}
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub

		return queue[0];
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub

		if (first() == null){
			System.out.print("Array Queue is Empty");
		}
		else {
			System.out.print("REMOVE     " + first() + " | ");
		}

		queue[0] = null;

		if (size > 0) {
			for (int i = 0; i < size; i++) {
				queue[i] = queue[i + 1];
			}
			size--;
		}
		print();

		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub

		if (first() != null) {
			System.out.print(first());
			for (int k = 1; k < size; k++) {

				System.out.print("<--" + queue[k]);

			}

		}
		System.out.println();

	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		Object[] temp = queue;
		queue = new Object[2 * temp.length];
		System.arraycopy(temp, 0, queue, 0, size);
	}

}
