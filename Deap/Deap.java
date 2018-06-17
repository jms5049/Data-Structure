
public class Deap {

	int[] deap;
	int n = 0;

	public Deap(int maxSize) {
		deap = new int[maxSize];
	}

	private boolean inMaxHeap(int i) {

		if (i == 0)
			System.out.println("index i is a root");

		for (int parent; (parent = (i - 1) / 2) > 0; i = parent);
		

		if (i == 2)
			return true;

		return false;
	}
	public static void main(String[] argv) {
		Deap a = new Deap(1024);

		int[] data = { 4, 65, 8, 9, 48, 55, 10, 19, 20, 30, 15, 25, 50 };
		for (int i = 0; i < data.length; i++) {
			a.insert(data[i]);
		}

		System.out.println("initial Deap");
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Min");
		a.deleteMin();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();
		System.out.println("delete Max");
		a.deleteMax();
		a.print();

	}
}