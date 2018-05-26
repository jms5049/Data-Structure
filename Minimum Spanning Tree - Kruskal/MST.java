
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
	
	public void Union(int i, int j) {
		TV[i] = j; 
	}

	public int find(int i) {
		for (; TV[i] >= 0; i = TV[i]) {
			
		}
		return i; 
	}

	private int index(String v) { 
		for (int i = 0; i < size; i++)
			if (vertices[i].equals(v))
				return i;
		return size;
	}

	public void add(String from, String to, int weight) {

		Edge edge = new Edge(from, to, weight); 
		E[eSize] = edge;
		eSize++;
	}


	public void delete() {
		E[0] = null;
		for (int i = 0; i < eSize - 1; i++) {
			E[i] = E[i + 1];
		}

		E[--eSize] = null;

	}

	public Edge[] sort(Edge[] E) {

		
		for (int i = 0; i < eSize - 1; i++) {
			for (int j = i + 1; j < eSize; j++) {
				if (E[i].getWeight() > E[j].getWeight()) {
					Edge temp = E[i];
					E[i] = E[j];
					E[j] = temp;
				}
			}
		}

		return E;
	}

	public void weightedunion(int i, int j) { 
		int temp;		temp = TV[i] + TV[j]; 
		if (TV[i] > TV[j]) { 
			TV[i] = j; 
			TV[j] = temp; 
		} else
			TV[j] = i; 
		TV[i] = temp; 

	}

	public void kruskal() {

		E = sort(E);
		int numbE = 0; // 간선의 수
		while (E != null && numbE < (size - 1)) {
			// n-1개 보다 적거나 같은 간선의 수를 가지고 간선의 배열 E가 null이 아닐시 반복
			Edge temp = E[0];
			delete();
			
			 /*if (find(index(temp.getFrom())) != find(index(temp.getTo()))) {
				 Union(find(index(temp.getFrom())), find(index(temp.getTo()))); 
				 ++numbE;
				 System.out.println(temp.getFrom() + ":" + temp.getTo()+ " = " +
					temp.getWeight()); cost += temp.getWeight();*/
			 
			if (collapsingfind(index(temp.getFrom())) != collapsingfind(index(temp.getTo()))) {
				weightedunion(collapsingfind(index(temp.getFrom())), collapsingfind(index(temp.getTo())));
				numbE++;
				System.out.println(temp.getFrom() + ":" + temp.getTo() + " = " + temp.getWeight());
				cost += temp.getWeight();
			} else {
				temp = null;
			}
		}

		if (numbE < (size - 1))
			System.out.println("No Spanning Tree");
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
