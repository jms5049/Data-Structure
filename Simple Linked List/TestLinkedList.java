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
			
			System.out.println("주소록을 읽어옵니다.");
			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");

				/* txt파일의 내용을 읽어와서 객체 배열(mPerson)에 저장한다. */
				/* 이름, 전화번호를 가져오기 위해서는 parser.nextToken()을 이용한다. */
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
			/*txt파일이 존재하지 않을 경우 예외 처리 */
			System.out.println("주소록을 불러 올수 없었습니다.");
		} catch (IOException e) {
		}
	}

}
