
public class TestMST {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MST M = new MST(new String[]{"A","B","C","D","E","F","G"});
		M.add("A", "B", 4);
		M.add("A", "F", 1);
		M.add("A", "G", 2);
		M.add("B", "C", 2);
		M.add("B", "G", 5);
		M.add("C", "D", 4);
		M.add("C", "G", 1);
		M.add("D", "E", 1);
		M.add("D", "G", 2);
		M.add("E", "F", 3);
		M.add("E", "G", 4);
		M.add("F", "G", 3);
		M.kruskal();
		System.out.println("MST Cost : " + M.cost);
	}

	

}
