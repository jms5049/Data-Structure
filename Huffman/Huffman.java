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

	public void printcode() {
		for (int i = 0; i < huffmancode.length; i++) {
			char letter = (char) (i + 65);
			if (huffmancode[i] != null)
				System.out.println(letter + "  : " + huffmancode[i]);
		}
	}

	public void encode(String[] word, int nextword, int[] wordinline, int lineNum) {
		
		int startLineIndex = wordinline[0];
		int endOfLine = wordinline[1] - 1;
		
		for (int j = 0; j <= lineNum; j++) {
			for (int i = startLineIndex; i <= endOfLine; i++) {
				String input = word[i];
				for (int k = 0; k < input.length(); k++) {
					char ch = input.charAt(k);
					int value = (int) ch;
					if (value >= 65 && value <= 90) {
						System.out.print(huffmancode[(value - 65)]);
						this.bitlength += huffmancode[(value - 65)].length();
					}
				}

			}

			startLineIndex = endOfLine + 1;
			endOfLine += wordinline[j + 1];
			if (startLineIndex > nextword || endOfLine > nextword) {
				System.out.println();
				break;
			}
			System.out.println();

		}

	}

	public int bitlength() {
		return this.bitlength;
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
