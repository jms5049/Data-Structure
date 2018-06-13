
public class TestAVL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLtree A = new AVLtree(44);
		A.add(88);
		A.add(55);
		A.add(77);
		A.add(33);
		A.add(99);
		A.add(66);
		A.add(22);
		A.add(25);
		A.add(75);
		System.out.println("AVL Tree \t:" + A);
		
		A.delete(25);
		A.delete(55);
		A.delete(75);
		A.delete(44);
		A.delete(88);
		System.out.println("After Delete \t:" + A);
	}
	

}
