
public class TestPrim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Prim P = new Prim(new String[]{"A","B","C","D","E","F","G"});
		P.add("A", "B", 4);
		P.add("A", "F", 1);
		P.add("A", "G", 2);
		P.add("B", "C", 2);
		P.add("B", "G", 5);
		P.add("C", "D", 4);
		P.add("C", "G", 1);
		P.add("D", "E", 1);
		P.add("D", "G", 2);
		P.add("E", "F", 3);
		P.add("E", "G", 4);
		P.add("F", "G", 3);
		P.prim("A");
		System.out.println("MST cost : " + P.cost);

	}

}
