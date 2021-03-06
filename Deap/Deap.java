
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

	public int deleteMax() {

		
		int max = deap[2];
		int temp = deap[n];
		deap[n]=0;	
		n--;	
		int i=2;	
		int j;

		while(deap[2*i+1] > 0){
			if(deap[2*i+1]<deap[2*i+2]){
				j = 2*i+2;
				deap[i]= deap[j];	
				i = j;
			}
			else {
				j = 2*i+1;
				deap[i] = deap[j];
				i = j;
			}			
		}
		
		deap[i]= temp;	
		int partner = minPartner(i);
		
		int k=partner;
		int q;		
		
		while(deap[2*k+1] > 0){
			if(deap[2*k+1] < deap[2*k+2]){
				q = 2*k+2;				
				k = q;
				
			}
			else {
				q = 2*k+1;				
				k = q;			
			}		
		}							
		
		if(deap[k] > temp){
			
			deap[i]=deap[k];
			minInsert(k,temp);
		}
		else{
			maxInsert(i,temp);
		}
		
		
		return max;

	}

	public int deleteMin() {
		
		int min = deap[1];
		int temp = deap[n];
		deap[n]=0;
		n--;
		int j;
		int i = 1;
		while(deap[2*i+1] > 0){
			if(deap[2*i+1]<deap[2*i+2]){
				j = 2*i +1;
				deap[i]= deap[j];
				i = j;
				
			}
			else {
				j = 2*i +2;
				deap[i] = deap[j];
				i = j;
			
			}			
		}
		
		
		deap[i]=temp;
		
		//compare
		int partner = maxPartner(i);
		
		if(deap[i] > deap[partner]){
			deap[i]=deap[partner];
			maxInsert(partner,temp);			
		}
		
		return min;

	}

	public void insert(int x) {

		if (n == deap.length - 1) {
			System.out.println("The heap is full");
			System.exit(1);
		}
		n++;

		if (n == 1) {
			deap[1] = x;
			return;
		}
		if (inMaxHeap(n)) {
			int i = minPartner(n);
			if (x < deap[i]) {
				deap[n] = deap[i];
				minInsert(i, x);
			} else {
				maxInsert(n, x);
			}
		} else {
			int i = maxPartner(n);
			if (x > deap[i]) {
				deap[n] = deap[i];
				maxInsert(i, x);
			} else {
				minInsert(n, x);
			}
		}
	}

	public void print() {
		int levelNum = 2;
		int thisLevel = 0;
		int gap = 8;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < gap - 1; j++) {
				System.out.print(" ");
			}
			if (thisLevel != 0) {
				for (int j = 0; j < gap - 1; j++) {
					System.out.print(" ");
				}
			}
			if (Integer.toString(deap[i]).length() == 1) {
				System.out.print(" ");
			}
			System.out.print(deap[i]);
			thisLevel++;
			if (thisLevel == levelNum) {
				System.out.println();
				thisLevel = 0;
				levelNum *= 2;
				gap /= 2;
			}
		}
		System.out.println();
		if (thisLevel != 0) {
			System.out.println();
		}
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