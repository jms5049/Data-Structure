
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Run {

	class Person {
		String name;
		String phoneNumber;
	}

	private int linesCount;
	private Person[] mPerson;

	public Run(String fileName, int size) {

		mPerson = new Person[size];

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);

			linesCount = 0;
			String line = br.readLine();

			while (line != null) {
				StringTokenizer parser = new StringTokenizer(line, " ");

				while (parser.hasMoreTokens()) {
					mPerson[linesCount] = new Person();

					mPerson[linesCount].name = parser.nextToken();
					mPerson[linesCount].phoneNumber = parser.nextToken();
				}
				linesCount++;
				line = br.readLine();
			}

			br.close();
			System.out.println("PhoneBook Loaded.");

		} catch (FileNotFoundException e) {
			System.out.println("PhoneBook Load Fail.");
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

		return "Not in list.";
	}

	public void update(String name, String phoneNumber) {

		Boolean isTrue = false;

		for (int q = 0; q < linesCount; q++) {
			if (name.equals(mPerson[q].name)) {

				System.out.print("'" + mPerson[q].name + "'s number"
						+ mPerson[q].phoneNumber + "->");
				mPerson[q].phoneNumber = phoneNumber;
				System.out.println(mPerson[q].phoneNumber + "updated.");
				isTrue = true;
			}

		}
		if (isTrue == false) {
			mPerson[linesCount] = new Person();
			mPerson[linesCount].name = name;
			mPerson[linesCount].phoneNumber = phoneNumber;
			System.out.println("'" + mPerson[linesCount].name + "' : "
					+ mPerson[linesCount].phoneNumber + "is added");
			linesCount++;
		}

	}

	public void print_to_file() {
		try {
			FileWriter Fw = new FileWriter("PhoneBookOut.txt", false);

			BufferedWriter bw = new BufferedWriter(Fw);

			System.out.println("Printing PhoneBook.");
			for (int k = 0; k < linesCount; k++) {
				bw.append(mPerson[k].name + " " + mPerson[k].phoneNumber);
				bw.newLine();
			}

			bw.flush();
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
