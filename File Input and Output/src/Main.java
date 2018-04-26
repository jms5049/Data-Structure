
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String fileName = "phonebook.txt";
		int size = 100;

		Run mRun = new Run(fileName, size);
	
		Scanner aScanner = new Scanner(System.in);
		String userinputname = null;

		System.out.print("Type Your Name: ");
		userinputname = aScanner.next();

		System.out.println(userinputname + "'s phone number is " + mRun.search(userinputname));
		
		String newuserinputname = null;
		String newuserinputnumber = null;
		
		
		System.out.print("Type your name: ");
		newuserinputname = aScanner.next();
		System.out.print("Type your phone number: ");
		newuserinputnumber = aScanner.next();

		mRun.update(newuserinputname, newuserinputnumber);
		
		System.out.print("Type your name: ");
		newuserinputname = aScanner.next();
		System.out.print("Type your phone number: ");
		newuserinputnumber = aScanner.next();
		
		mRun.update(newuserinputname, newuserinputnumber);
		
		mRun.print_to_file();

	}

}
