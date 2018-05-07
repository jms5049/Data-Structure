
public class BST {
	private Comparable key;
	private BST left, right;
	private BST root;
	private int rHeight;
	private int lHeight;

	private int leftSubtreeHeight;
	private int rightSubtreeHeight;

	public BST() {
		this.root = this;
	}

	public BST(Comparable key) {
		this.key = key;
		this.leftSubtreeHeight = 0;
		this.rightSubtreeHeight = 0;
	}

	public void insert(Object key) {

		if (this.key == null) {
			this.key = (Comparable) key;

		} else {
			if (this.key.compareTo((Comparable) key) < 0) {
				if (this.right == null) {
					this.right = new BST((Comparable) key);

				} else {
					this.right.insert(key);	
				}

			} else {
				if (this.left == null) {
					this.left = new BST((Comparable) key);

				} else {
					this.left.insert(key);
				}
			}

		}
	}
	
	public Object height(BST bst) {
		if (bst == null) {	
			return 0;
		} else {	
			if (bst.left != null) {	
				leftSubtreeHeight++;	
				height(bst.left);	
			}
			if (bst.right != null) {	
				rightSubtreeHeight++;	
				height(bst.right);	
			}
		}
		
		if (leftSubtreeHeight > rightSubtreeHeight){	
			return leftSubtreeHeight;					
		}
		else{
			return rightSubtreeHeight;
		}


	}

	public void inorder(BST bst) {
		if (bst == null) { 
			return;
		}
		inorder(bst.left); 
		System.out.print(bst.key + " ");	
		inorder(bst.right);	

	}


}