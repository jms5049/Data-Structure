
public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(new String[]{"A","B","C","D","E","F"});
		System.out.println(g);
		g.add("A", "B");
		g.add("B", "C");
		g.add("B", "D");
		g.add("C", "D");
		g.add("C", "E");
		g.add("D", "E");
		g.add("C", "F");
		g.add("D", "F");
		System.out.println(g);
		
	}

}
