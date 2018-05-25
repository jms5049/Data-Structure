
public class MST {

	int size;
	int eSize;
	int cost;
	int[] TV;
	String[] vertices;
	Edge[] E;

	public MST(String[] args) {
		// TODO Auto-generated constructor stub
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size); 
		TV = new int[size];
		for (int i = 0; i < size; i++) {
			TV[i] = -1; 
		}
		E = new Edge[100];
	}

	class Edge { 
		String from; 
		String to; 
		int weight;

		public Edge() {

		}

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

		public int getWeight() {
			return weight;
		}

	}

}
