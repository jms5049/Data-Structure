
public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SlinkedQueue bought = new SlinkedQueue();
		SlinkedQueue sold = new SlinkedQueue();

		java.util.Random random = new java.util.Random();

		ExponentialRandom randombuy = new ExponentialRandom(5);
		ExponentialRandom randomsell = new ExponentialRandom(10);

		int gain;
		gain = 0;
		SlinkedQueue.Node buy = bought.first();
		SlinkedQueue.Node sell = sold.first();
		int nextrandombuy=randombuy.nextInt();
		int nextrandomsell=randomsell.nextInt();
		
		for (int i = 0; i < 100; i++) {
			System.out.println("--------------- Time : " + i + " ---------------");
			if (i == nextrandombuy) {
				System.out.print("Bought (info save)\t| ");
				bought.add(random.nextInt(1500), random.nextInt(20));
				nextrandombuy=i+randombuy.nextInt();
			}
			if (i == nextrandomsell) {
				System.out.print("Sold (info save)		| ");
				sold.add(random.nextInt(1500), random.nextInt(20));

				buy = bought.first();
				sell = sold.first();
				if (buy != null && sell != null) {

					while (buy != null && sell != null) {
						if ((int) buy.amount < (int) sell.amount) {
							gain = gain + (int) buy.amount * ((int) sell.price - (int) buy.price);
							bought.remove();
							sold.first().amount = (int) sold.first().amount - (int) buy.amount;
						} else {
							gain = gain + (int) sell.amount * ((int) sell.price - (int) buy.price);
							sold.remove();
							if ((int) buy.amount == (int) sell.amount) {
								bought.remove();
							} else {
								bought.first().amount = (int) bought.first().amount - (int) sell.amount;
							}
						}
						System.out.print("Bought (After Sale Request)\t| ");
						bought.print();
						System.out.print("Sold (After Sale Request)		| ");
						sold.print();
						System.out.println("Gains : " + gain + "dollar");
						buy = bought.first();
						sell = sold.first();
					}
				}
				nextrandomsell=i+randomsell.nextInt();

			}

		}
	}

}
