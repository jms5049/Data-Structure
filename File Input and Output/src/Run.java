
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Run {

	/* �̸��� ��ȭ��ȣ�� ������ ���� ���� Ŭ���� */
	class Person {
		String name;
		String phoneNumber;
	}

	private int linesCount; /* �о�� line �� ���� */
	private Person[] mPerson; /* �̸��� ��ȭ��ȣ�� ������ ���� ��ü �迭 ���� */

	/* ������ ������ �ؽ�Ʈ ������ �о�� */

	public Run(String fileName, int size) {

		mPerson = new Person[size]; /* ��ü �迭�� size��ŭ �Ҵ���. */

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			linesCount = 0;
			String line = br.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");

				/* txt������ ������ �о�ͼ� ��ü �迭(mPerson)�� �����Ѵ�. */
				/* �̸�, ��ȭ��ȣ�� �������� ���ؼ��� parser.nextToken()�� �̿��Ѵ�. */
				while (parser.hasMoreTokens()) {
					mPerson[linesCount] = new Person();

					mPerson[linesCount].name = parser.nextToken();
					mPerson[linesCount].phoneNumber = parser.nextToken();
				}
				linesCount++;
				line = br.readLine();
			}

			br.close();
			System.out.println("�ּҷ� �б� ����.");

		} catch (FileNotFoundException e) {
			/* txt������ �������� ���� ��� ���� ó�� */
			System.out.println("�ּҷ� ������ ã�� �� �����ϴ�.");
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

		return "�̸��� ��Ͽ� �����ϴ�.";
	}

	public void update(String name, String phoneNumber) {

		Boolean isTrue = false;

		for (int q = 0; q < linesCount; q++) {
			if (name.equals(mPerson[q].name)) {

				System.out.print("'" + mPerson[q].name + "'�� ��ȣ��(��)"
						+ mPerson[q].phoneNumber + "->");
				mPerson[q].phoneNumber = phoneNumber;
				System.out.println(mPerson[q].phoneNumber + "(��)�� �����߽��ϴ�.");
				isTrue = true;
			}

		}
		if (isTrue == false) {
			mPerson[linesCount] = new Person();
			mPerson[linesCount].name = name;
			mPerson[linesCount].phoneNumber = phoneNumber;
			System.out.println("'" + mPerson[linesCount].name + "' : "
					+ mPerson[linesCount].phoneNumber + "��(��) �߰��޽��ϴ�");
			linesCount++;
		}

	}

	public void print_to_file() {
		try {
			/* fileName �� ���� �۾� */
			FileWriter Fw = new FileWriter("PhoneBookOut.txt", false);

			BufferedWriter bw = new BufferedWriter(Fw);

			/* �ݺ����� ����Ͽ� ��ü �迭(mPerson)�� ����� ������ txt���Ͽ� �߰���. */

			System.out.println("��ȭ��ȣ�θ� ����մϴ�.");
			for (int k = 0; k < linesCount; k++) {
				bw.append(mPerson[k].name + " " + mPerson[k].phoneNumber);
				bw.newLine();
			}

			/* �ؽ�Ʈ ���� ��� */
			bw.flush();

			/* ���� ���� ��ü�� ����. */
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
