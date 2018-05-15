
public class Graph {
	int size;
	int indexNumber;
	String[] array; // 스트링 배열
	Node[] nodeArray; // 노드 배열
	int p, q;

	public Graph(String[] args) {
		size = args.length;
		array = new String[size]; 
		System.arraycopy(args, 0, array, 0, size); 
													// 그대로 복사한다.
		nodeArray = new Node[size];
		for (int i = 0; i < size; i++) { 
			nodeArray[i] = new Node(i, null);
		}
	}

	public void add(String v, String w) {
		int first;
		int second;

		first = index(v); 
		second = index(w); 

		for (int i = 0; i < size; i++) { 
			if (i == first) { 
				if (nodeArray[first].next == null) {
					nodeArray[first].next = new Node(second, null); 
					
					if (nodeArray[second].next == null) { 
						nodeArray[second].next = new Node(first, null);
						nodeArray[second].next = new Node(first, nodeArray[second].next);
					}
				} else {
					nodeArray[first].next = new Node(second, nodeArray[first].next);
					if (nodeArray[second].next == null) {
						nodeArray[second].next = new Node(first, null);
					} else {
						nodeArray[second].next = new Node(first, nodeArray[second].next);
					}
				}

			}
		}

	}

	private class Node {
		int to;
		Node next;

		Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}
}
