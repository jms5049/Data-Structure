

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

	public String toString() {
		if (this == NIL)
			return "";
		return left + " " + key + " " + right;
	}

	private AVLtree() { // constructs the empty tree
		left = right = this;
		height = -1;
	}

	private AVLtree(int key, AVLtree left, AVLtree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}

	private void rebalance() {
		if (right.height > left.height + 1) {
			if (right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		}

		else if (left.height > right.height + 1) {
			if (left.right.height > left.left.height)
				left.rotateLeft();
			rotateRight();
		}
	}

	private void rotateLeft() {
		left = new AVLtree(key, left, right.left);
		key = right.key;
		right = right.right;
	}

	private void rotateRight() {
		right = new AVLtree(key, left.right, right);
		key = left.key;
		left = left.left;
	}

	private AVLtree findMin(AVLtree key) {
		
		AVLtree Min = key.right;
		AVLtree MinParent = key;
		
		while (Min.left != NIL) {
			
			MinParent = Min;
			Min = Min.left;
		}

		if (Min == key.right)
			
			return Min;
		
		else if (Min != key.right) {
			
			MinParent.left = Min.right;
			
		}

		return Min;
	}

	public AVLtree delete(int key) {
		if (this == NIL)
			return NIL;
 
		else if (key < this.key)
			left = left.delete(key); 
		else
			right = right.delete(key);

		if (this.key == key) {
			if (left == NIL && right == NIL)
				return NIL;
			
			else if (left != NIL && right == NIL)
				return this.left;

			else if (left == NIL && right != NIL)
				return this.right;
			
			else if (left != NIL && right != NIL) {
				if (this.right.left == NIL)
					return new AVLtree(findMin(this).key, this.left,right.right);
				else{
				this.key = findMin(this).key;
				return this;
				}	
			}
		}

		rebalance();	
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

}
