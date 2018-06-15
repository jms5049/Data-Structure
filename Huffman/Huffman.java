package huffmantree;

public class Huffman {
	HeapPriorityQueue queue;
	String[] huffmancode = new String[27];
	int bitlength = 0;

	public Huffman() {
		// TODO Auto-generated constructor stub

	}

	public Huffman(HeapPriorityQueue pqueue) {
		// TODO Auto-generated constructor stub
		this.queue = pqueue;
	}

	public HeapPriorityQueue mergeTree() {
		// TODO Auto-generated method stub
		trecord x;
		trecord y;
		while (this.queue.size() > 1) {
			x = (trecord) this.queue.removeBest();
			y = (trecord) this.queue.removeBest();
			this.queue.add(new trecord(x, y));
			}
		huffcode((trecord) this.queue.best(), " ");
		System.out.println();
		return this.queue;
	}

	public void huffcode(trecord root, String code) {

		
		
		if (root.lchild != null) {
			
			root.lchild.code = root.code + "0";
			huffcode(root.lchild, code);
			
			root.rchild.code = root.code + "1";
			huffcode(root.rchild, code);
			}

		else {
			huffmancode[root.alphabet - 65] = root.code;
		}

	}

	

	public class trecord implements Comparable {
		
		private trecord lchild;
		private char alphabet;
		private int freq;
		private String code;
		private trecord rchild;
		
		public trecord(char alphabet, int freq) {
			this.alphabet = alphabet;
			this.freq = freq;
			this.lchild = null;
			this.rchild = null;
			this.code = "";
		}

		public trecord(trecord lchild, trecord rchild) {
			this.alphabet = 0;
			this.freq = lchild.freq + rchild.freq;
			this.lchild = lchild;
			this.rchild = rchild;
			this.code = "";
		}

		@Override
		public int compareTo(Object object) {
			// TODO Auto-generated method stub
			if (!(object instanceof trecord))
				throw new IllegalArgumentException();
			trecord that = (trecord) object;
			return that.freq - this.freq;
		}

	}

}
