import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestHashing {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearProbing LP = new LinearProbing();
		QuadraticProbing QP = new QuadraticProbing();
		DoubleHashing DH = new DoubleHashing(); 
		SeparateChaining SC = new SeparateChaining(); 
		
		int lineNumber=0;		
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("input.txt"));
			String line = in.readLine();

			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " .,:;-?!");

				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
				
						LP.put(word,1);
						QP.put(word,1);
						DH.put(word,1);
						SC.put(word,1); 
				}
				line = in.readLine();

			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println("Collision of Linear Probing\t: " + LP.getCount());
		System.out.println("Collision of Quadratic Probing\t: " + QP.getCount());
		System.out.println("Collision of DoubleHashing\t: " + DH.getCount());
		System.out.println("Collision of SeparateChaining\t: " + SC.getCount());
		System.out.println("I\t: " + LP.get("I")+"회");
		System.out.println("YOU\t: " +LP.get("YOU")+"회");
		System.out.println("HE\t: " +LP.get("HE")+"회");
		System.out.println("BRUTUS\t: " +LP.get("BRUTUS")+"회");
		System.out.println("EVIL\t: " +LP.get("EVIL")+"회");
		System.out.println("THE\t: " +LP.get("THE")+"회");
		System.out.println("AND\t: " +LP.get("AND")+"회");
	}
}
