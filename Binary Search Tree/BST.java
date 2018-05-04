
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
			if (this.key.compareTo((Comparable) key) < 0) {	//입력받은 키값과 루트의 키값과 비교해서 입력받은 키값이 더 크다면
				if (this.right == null) {	//만약 루트 노드의 오른쪽자식이 없다면
					this.right = new BST((Comparable) key);	//입력받은 키 값을 가진 노드를 오른쪽 자식으로 붙여준다.

				} else {
					this.right.insert(key);	//루트 노드보다 크고 루트 노드에 오른쪽 자식이 잇다면, 그 오른쪽 자식과 입력받은 key 값과 비교를 해서 어디에 넣을 지를 알아내기 위해 재귀함수를 쓴다.
				}

			} 

		}
	}

}