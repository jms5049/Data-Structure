
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		String fileName = "phonebook.txt"; /* �о�� txt���� �̸� */
		int size = 100; /* ��ü �迭�� ũ�� */

		Run mRun = new Run(fileName, size);
		
		// Search �޼ҵ带 �ҷ���//
		
		Scanner aScanner = new Scanner(System.in);
		String userinputname = null;

		System.out.print("�̸��� �Է��Ͻÿ�: ");
		userinputname = aScanner.next();

		System.out.println(userinputname + "�� ��ȭ��ȣ�� " + mRun.search(userinputname) + " �Դϴ�.");
		
		//Update �޼ҵ带 �ҷ���//
		
		String newuserinputname = null;
		String newuserinputnumber = null;
		
		
		System.out.print("�̸��� �Է��Ͻÿ�: ");
		newuserinputname = aScanner.next();
		System.out.print("��ȭ��ȣ�� �Է��Ͻÿ�: ");
		newuserinputnumber = aScanner.next();

		mRun.update(newuserinputname, newuserinputnumber);
		
		System.out.print("�̸��� �Է��Ͻÿ�: ");
		newuserinputname = aScanner.next();
		System.out.print("��ȭ��ȣ�� �Է��Ͻÿ�: ");
		newuserinputnumber = aScanner.next();
		
		mRun.update(newuserinputname, newuserinputnumber);
				
		//print �޼ҵ带 �ҷ���//
		
		mRun.print_to_file();

	}

}
