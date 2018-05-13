public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
	}

	public void add(String v, String w) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return a.length;
	}

	public String toString() {
		
		if (size == 0)
			return "{}";
		
		StringBuffer buf = new StringBuffer(vertex(0));
		for (int i = 1; i < size; i++)
			
			buf.append("\n"+vertex(i));
		
		
		
		return buf + "";
	}


	
}
