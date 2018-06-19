
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

	private int maxPartner(int pos) {

		double height = Math.floor(Math.log(pos + 1) / Math.log(2));

		int j = (pos + (int) (Math.pow(2, (height - 1))));
		
		if (j > n) {
			j = (j - 1) / 2;
		}
		
		return j;

	}

	private int minPartner(int pos) {
		Double exponent = Math.floor(Math.log(pos + 1) / Math.log(2)) - 1;
		return (int) (pos - Math.pow(2, exponent));
	}

	private void minInsert(int at, int key) {
		for (int parent; (parent = (at - 1) / 2) != 0 && key < deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
	}

	private void maxInsert(int at, int key) {

		for (int parent; (parent = (at - 1) / 2) != 0 && key > deap[parent]; deap[at] = deap[parent], at = parent)
			;
		deap[at] = key;
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