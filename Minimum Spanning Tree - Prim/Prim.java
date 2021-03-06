
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

	public void add(String from, String to, int weight) { 
		
		int i = index(from), j = index(to);
		W[i][j] = W[j][i] = weight; 
	}
	
	public void addT(String from, String to, int weight) {
		
		Edge e = new Edge(from, to, weight);
		T[numE] = e;
		numE++;
		
	}

	public void prim(String randomVertex) {
		
		
		TV[index(randomVertex)] = true; 

		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) {
				if (W[i][j] == 0) 
					W[i][j] = 99; 
			}
		}

		
		while (numE <= size-1){
			
			
			int temp = 99;
			for (int i = 0; i < size; i++) {
				if (TV[i] == true) {
					for (int j = 0; j < size; j++) {
						if (TV[j] == false) {
							if (temp > W[i][j]) {
																
							}							
						}						
					}
				}				
			}
			TV[vto] = true;
			addT(vertices[ufrom],vertices[vto],temp); 
		}
		
		if (numE <= size -1){
			
			System.out.println("No Spanning Tree");
		}
		else{
			for(int i = 0; i < numE-1; i++){
				System.out.println("Selected Edge : " + "(" + T[i].getFrom() + "," + T[i].getTo() + "," + T[i].getWeight() + ")");
				cost += T[i].getWeight();
			}
			
		}
		
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
