import java.util.*;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree btreeA, btreeB, btreeC, btreeD, btreeF, btreeG; // 자식이 하나라도
																	// 있는 애들은 따로
																	// 빼줌
		BinaryTree btreeH = new BinaryTree("H"); // 리프노드들 H E I J K
		BinaryTree btreeE = new BinaryTree("E");
		BinaryTree btreeI = new BinaryTree("I");
		BinaryTree btreeJ = new BinaryTree("J");
		BinaryTree btreeK = new BinaryTree("K");

		btreeD = new BinaryTree("D", null, btreeH); // 순서대로 루트값, 왼쪽자식, 오른쪽자식
		btreeF = new BinaryTree("F", btreeI, null);
		btreeG = new BinaryTree("G", btreeJ, btreeK);
		btreeB = new BinaryTree("B", btreeD, btreeE);
		btreeC = new BinaryTree("C", btreeF, btreeG);
		btreeA = new BinaryTree("A", btreeB, btreeC);

		System.out.println("BinaryTree 출력\t\t: " + btreeA.toString());
		System.out.print("BinaryTree Postorder\t: ");
		btreeA.postorder(btreeA);

	}

}
