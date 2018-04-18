import java.util.Random;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayQueue Queue = new ArrayQueue();
		ArrayStack Stack = new ArrayStack();

		Random RandomInt = new Random();

		for (int i = 0; i < 10; i++) {
			Stack.push(RandomInt.nextInt(100));
			Queue.add(RandomInt.nextInt(100));

		}

		System.out.println("********** Test ArrayStack **********");

		for (int j = 0; j < 11; j++) {

			if (!Stack.isEmpty()) {
				System.out.println(j + " : " + (int) Stack.peek() + " / "
						+ (int) Stack.pop());
			} else {
				System.out.println(j + " : Stack is Empty / Stack is Empty");

			}
		}
		System.out.println("");

			System.out.println("********** Test ArrayQueue **********");

			for (int k = 0; k < 11; k++) {
				
				if (!Queue.isEmpty()){
				System.out.println(k + " : " + (int) Queue.first() + " / "
						+ (int) Queue.deQueue());
				}
				else{
					System.out.println(k + " : Queue is Empty / Queue is Empty");
				}
			}

		}

	}

