import java.util.*;

public class BinaryTree {
	private Object root;
	private BinaryTree left, right;

	public BinaryTree(Object root) {
		this.root = root;
		this.left = null; 
		this.right = null;
	}

	public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
		this.root = root;
		this.left = left;
		this.right = right;

	}

	public Object getRoot() {
		return root;
	}

	public void postorder(BinaryTree tree) {
		if (tree == null) {
			return;
		}
		postorder(tree.left);
		postorder(tree.right);
		System.out.print(tree.root + " ");
		
	}

	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		if (left != null)
			buf.append(left + ",");
		buf.append(root);
		if (right != null)
			buf.append("," + right);
		return buf + "]";
	}

}
