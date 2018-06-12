

public class AVLtree {
	private int key, height;
	private AVLtree left, right;
	public static final AVLtree NIL = new AVLtree();	

	public AVLtree(int key) {
		this.key = key;
		left = right = NIL;
	}

	public boolean add(int key) {
		int oldSize = size(); 
		grow(key);
		return size() > oldSize;
	}

	public AVLtree grow(int key) {
		if (this == NIL)
			return new AVLtree(key);
		if (key == this.key)
			return this; // prevent key duplication
		if (key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	public int size() {
		if (this == NIL)
			return 0;
		return 1 + left.size() + right.size();
	}

	
}
