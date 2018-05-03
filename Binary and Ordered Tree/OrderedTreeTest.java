import java.util.*;

public class OrderedTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OrderedTree treeA, treeB, treeC, treeD, treeF, treeG;
		OrderedTree treeH = new OrderedTree("H");
		OrderedTree treeE = new OrderedTree("E");
		OrderedTree treeI = new OrderedTree("I");
		OrderedTree treeJ = new OrderedTree("J");
		OrderedTree treeK = new OrderedTree("K");

		// 부모 D 만들기
		List<Object> subtreesOfD = new LinkedList<Object>();
		subtreesOfD.add(treeH); // 자식은 D를 가진다.
		treeD = new OrderedTree("D", subtreesOfD);

		// 부모 F만들기
		List<Object> subtreesOfF = new LinkedList<Object>();
		subtreesOfF.add(treeI); // 자식 I를 가진다.
		treeF = new OrderedTree("F", subtreesOfF);

		// 부모 G만들기
		List<Object> subtreesOfG = new LinkedList<Object>();
		subtreesOfG.add(treeJ);
		subtreesOfG.add(treeK);
		treeG = new OrderedTree("G", subtreesOfG);

		// 부모 B만들기
		List<Object> subtreesOfB = new LinkedList<Object>();
		subtreesOfB.add(treeD);
		subtreesOfB.add(treeE);
		treeB = new OrderedTree("B", subtreesOfB);

		// 부모 C만들기
		List<Object> subtreesOfC = new LinkedList<Object>();
		subtreesOfC.add(treeF);
		subtreesOfC.add(treeG);
		treeC = new OrderedTree("C", subtreesOfC);

		// 루트 A 만들기
		List<Object> subtreesOfA = new LinkedList<Object>();
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		treeA = new OrderedTree("A", subtreesOfA);

		System.out.print("OrderedTree Postorder\t: ");
		treeA.postorder();

	}

}
