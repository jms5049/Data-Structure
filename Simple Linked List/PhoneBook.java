import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class PhoneBook {

	Person start = null;

	class Person {
		String name;
		String phoneNumber;
		Person next;

		public Person(String name, String phoneNumber, Person next) { // Person
																		// 의 생성자
			this.name = name; // 현재 클래스에 잇는 변수 name에다가 받아온 인자 값을 넣는다.
			this.phoneNumber = phoneNumber; // 번호 인자 값을 넣는다.
			this.next = next;
		}
	}

	public void insert(String name, String phoneNumber) {
		if (start == null || start.name.compareTo(name) > 0)

		{
			start = new Person(name, phoneNumber, start);
		}
		else 
		{Person p = start;

		while (p.next != null) {
			if (p.next.name.compareTo(name) > 0) {
				break;
			}
			p = p.next;
		}
		p.next = new Person(name, phoneNumber, p.next);
		}

		
	}
	
	public void print() {
		int n = 1;
		Person p = start;
		System.out.println("");
		System.out.println("전화번호를 출력합니다.");
		while (p!= null) {
			
			System.out.println(n + " : " + p.name + " - " + p.phoneNumber);
			p = p.next;
			n++;
		}

	}
}
