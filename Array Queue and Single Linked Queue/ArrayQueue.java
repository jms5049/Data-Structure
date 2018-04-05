public class ArrayQueue implements Queue {
	Object queue[]; // queue에 사용할 배열
	int size; // queue에 저장된 원소의 개수
	int queueSize; // queue의 크기

	public ArrayQueue(int queueSize) { // 생성자
		// queue 초기화
		this.queue = new Object[queueSize];
		this.queueSize = queueSize;
		this.size = 0;
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		queue[size] = object;
		size++;

		if (size > queueSize) { // 원소의 개수가 배열의 크기보다 클때
			System.out.println("Array Queue is Full! RESIZE");
		}
		if (size == queueSize) { // 원소의 개수가 배열의 크기와 같을때 

			resize();
		} else {
			System.out.print("ADD        " + object + " | ");
			print();
		}
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub

		// 배열의 첫 원소
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
