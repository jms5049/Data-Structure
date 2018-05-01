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

	public void postorder() {
		for (Iterator it = subtrees.iterator(); it.hasNext();) {
			// 서브트리를 반복하는 이터레이터 선언 후에, 자식이 있는 한 무한 루프를 돌린다
			((OrderedTree) it.next()).postorder();
			// 이터레이터를 사용하여 재귀함수 구현

		}
		System.out.print(root + " ");
	}

	public int size() {
		return size;
	}

}
