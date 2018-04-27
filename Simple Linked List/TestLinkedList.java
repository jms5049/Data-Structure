import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;



public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PhoneBook mPhoneBook = new PhoneBook();

		try {
			FileReader fr = new FileReader("PhoneBook.txt");
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			
			System.out.println("Load PhoneBook.");
			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");
				while (parser.hasMoreTokens()) {

					String x = parser.nextToken();
					String y = parser.nextToken();

					
					System.out.println("삽입 : " + x + " - " + y);

					mPhoneBook.insert(x, y);
					
					}
				line = br.readLine();
				
			}			
			br.close();
			
			mPhoneBook.print();
		
		} catch (FileNotFoundException e) {
			System.out.println("Load Failure.");
		} catch (IOException e) {
		}
	}

}
