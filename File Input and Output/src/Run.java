
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Run {

	/* 이름과 전화번호를 변수로 갖는 내부 클래스 */
	class Person {
		String name;
		String phoneNumber;
	}

	private int linesCount; /* 읽어온 line 수 저장 */
	private Person[] mPerson; /* 이름과 전화번호를 변수로 갖는 객체 배열 선언 */

	/* 생성자 내에서 텍스트 파일을 읽어옴 */

	public Run(String fileName, int size) {

		mPerson = new Person[size]; /* 객체 배열을 size만큼 할당함. */

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			linesCount = 0;
			String line = br.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");

				/* txt파일의 내용을 읽어와서 객체 배열(mPerson)에 저장한다. */
				/* 이름, 전화번호를 가져오기 위해서는 parser.nextToken()을 이용한다. */
				while (parser.hasMoreTokens()) {
					mPerson[linesCount] = new Person();

					mPerson[linesCount].name = parser.nextToken();
					mPerson[linesCount].phoneNumber = parser.nextToken();
				}
				linesCount++;
				line = br.readLine();
			}

			br.close();
			System.out.println("주소록 읽기 성공.");

		} catch (FileNotFoundException e) {
			/* txt파일이 존재하지 않을 경우 예외 처리 */
			System.out.println("주소록 파일을 찾을 수 없습니다.");
		} catch (IOException e) {
		}
	}

	public String search(String name) {

		for (int j = 0; j < linesCount; j++) {
			if (name.equals(mPerson[j].name)) {
				return mPerson[j].phoneNumber;
			}
			;

		}
		;

		return "이름이 목록에 없습니다.";
	}

	public void update(String name, String phoneNumber) {

		Boolean isTrue = false;

		for (int q = 0; q < linesCount; q++) {
			if (name.equals(mPerson[q].name)) {

				System.out.print("'" + mPerson[q].name + "'의 번호을(를)"
						+ mPerson[q].phoneNumber + "->");
				mPerson[q].phoneNumber = phoneNumber;
				System.out.println(mPerson[q].phoneNumber + "(으)로 수정했습니다.");
				isTrue = true;
			}

		}
		if (isTrue == false) {
			mPerson[linesCount] = new Person();
			mPerson[linesCount].name = name;
			mPerson[linesCount].phoneNumber = phoneNumber;
			System.out.println("'" + mPerson[linesCount].name + "' : "
					+ mPerson[linesCount].phoneNumber + "을(를) 추가햇습니다");
			linesCount++;
		}

	}

	public void print_to_file() {
		try {
			/* fileName 에 쓰기 작업 */
			FileWriter Fw = new FileWriter("PhoneBookOut.txt", false);

			BufferedWriter bw = new BufferedWriter(Fw);

			/* 반복문을 사용하여 객체 배열(mPerson)에 저장된 내용을 txt파일에 추가함. */

			System.out.println("전화번호부를 출력합니다.");
			for (int k = 0; k < linesCount; k++) {
				bw.append(mPerson[k].name + " " + mPerson[k].phoneNumber);
				bw.newLine();
			}

			/* 텍스트 파일 출력 */
			bw.flush();

			/* 파일 쓰기 객체를 닫음. */
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
