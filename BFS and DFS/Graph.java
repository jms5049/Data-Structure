
public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;
	boolean[] visitBFS;
	boolean[] visitDFS;

	public Graph(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
		visitDFS = new boolean[size];
	}

	public void add(String v, String w) {
		int i = index(v), j = index(w);
		a[i][j] = a[j][i] = true;
	}

	
}
