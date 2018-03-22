
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String fileName = "phonebook.txt"; /* 읽어올 txt파일 이름 */
		int size = 100; /* 객체 배열의 크기 */

		Run mRun = new Run(fileName, size);
		
		// Search 메소드를 불러옴//
		
		Scanner aScanner = new Scanner(System.in);
		String userinputname = null;

		System.out.print("이름을 입력하시오: ");
		userinputname = aScanner.next();

		System.out.println(userinputname + "의 전화번호는 " + mRun.search(userinputname) + " 입니다.");
		
		//Update 메소드를 불러옴//
		
		String newuserinputname = null;
		String newuserinputnumber = null;
		
		
		System.out.print("이름을 입력하시오: ");
		newuserinputname = aScanner.next();
		System.out.print("전화번호를 입력하시오: ");
		newuserinputnumber = aScanner.next();

		mRun.update(newuserinputname, newuserinputnumber);
		
		System.out.print("이름을 입력하시오: ");
		newuserinputname = aScanner.next();
		System.out.print("전화번호를 입력하시오: ");
		newuserinputnumber = aScanner.next();
		
		mRun.update(newuserinputname, newuserinputnumber);
				
		//print 메소드를 불러옴//
		
		mRun.print_to_file();

	}

}
