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

	public OrderedTree(Object root, List<Object> trees) {
		this(root);
		for (Iterator it = trees.iterator(); it.hasNext();) {
			Object object = it.next();
			if (object instanceof OrderedTree) {
				OrderedTree tree = (OrderedTree) object;
				subtrees.add(tree);
				size += tree.size();
			}
		}
	}

	public int size() {
		return size;
	}

}
