
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

}