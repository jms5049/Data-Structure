import java.util.*;

public class OrderedTree {
	private Object root;
	private List<Object> subtrees;
	private int size;

	public OrderedTree() {

	}

	public OrderedTree(Object root) {
		this.root = root;
		subtrees = new LinkedList<Object>();
		size = 1;
	}

	public int size() {
		return size;
	}

}
