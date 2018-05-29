
public class Prim {

	int size, cost,numE = 0;
	String[] vertices;
	boolean[] TV;
	int[][] W;
	Edge[] T;
	int ufrom, vto = 0;

	public Prim(String[] args) {
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		TV = new boolean[size];
		W = new int[size][size];
		for (int i = 0; i < size; i++) {
			TV[i] = false;
		}
		T = new Edge[99];
		
	}

	private int index(String v) { 
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return size;
	}
	
	private class Edge{
		
		String from; 
		String to;
		int weight;	

		public Edge(String from, String to, int weight) {
			
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		public String getFrom() {
			return from;
		}
		public String getTo() {
			return to;
		}		
		public int getWeight(){
			return weight;
		}
	}
}
