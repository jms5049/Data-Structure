import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TestGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		int lineNumber = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader("Graph.txt"));
			String line = in.readLine();

			String graphArray[];
			graphArray = new String[100];

			while (line != null) {
				++lineNumber;

				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");

				while (parser.hasMoreTokens()) {

					String word = parser.nextToken().toUpperCase();

					if (lineNumber > 1) {
						graphArray[x] = word;
						++x;
					}

				}

				// System.out.println(lineNumber + ":\t" + line);
				line = in.readLine();

			}
			in.close();

			Graph g = new Graph(new String[] { graphArray[0], graphArray[1], graphArray[2], graphArray[3],
					graphArray[4], graphArray[5] });

			for (int index = 0; index < 6; index++) {
				System.out.print("     " + graphArray[index]);
			}

			System.out.println("");

			for (int lin = 6; lin < 100; lin++) {
				g.add(graphArray[lin], graphArray[lin++]);
				lin++;
				if (graphArray[lin] == null)
					break;
			}

			g.add(graphArray[6], graphArray[7]);
			g.add(graphArray[8], graphArray[9]);
			g.add(graphArray[10], graphArray[11]);
			g.add(graphArray[12], graphArray[13]);
			g.add(graphArray[14], graphArray[15]);
			g.add(graphArray[16], graphArray[17]);
			g.add(graphArray[18], graphArray[19]);
			g.add(graphArray[20], graphArray[21]);

			System.out.println(g);

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
