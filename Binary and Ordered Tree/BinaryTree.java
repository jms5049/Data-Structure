import java.util.*;

public class BinaryTree {
	private Object root;
	private BinaryTree left, right;

	public BinaryTree(Object root) {
		this.root = root;
		this.left = null; // 자식이 없는 empty tree
		this.right = null; // 자식이 없는 empty tree
	}

	public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
		this.root = root;
		this.left = left;
		this.right = right;

	}

	public Object getRoot() {
		return root;
	}

}
