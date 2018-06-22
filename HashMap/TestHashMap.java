import java.util.HashMap;	//hashmap import
import java.util.StringTokenizer;
import java.io.*;

public class TestHashMap {

	public static void main(String[] args) {
	
	int a = 0;
	HashMap hash = new HashMap();
	// HashMap ��ü ����
	
	//input�̶�� ������ ���� ���� �Ͼ�µ�
	//�� ���� ������ .,;: ?! �� ������ �߶� �ܾ� ������ �����, �� �ܾ���� key������ �־��ְ�, value�� 1�� �־��ش�.
	try {
		BufferedReader in = new BufferedReader(new FileReader("Caesar.txt"));
		String line = in.readLine();
		
		while (line != null) {
			
			StringTokenizer parser = new StringTokenizer(line, " .,:;-?!");

			while (parser.hasMoreTokens()) {
				String word = parser.nextToken().toUpperCase();
							
				if(hash.containsKey(word)){	//word�� �ؽ����̺� �̹� �����Ѵٸ�
					a=(int) hash.get(word);	// �� value�� a�� �޴´�
					a++;	// a�� 1��ŭ ������Ų��
					hash.put(word, a);	//������Ų a�� �ٽ� �ؽ����̺� �־��ش�
				}
				else{	//�������� �ʴٸ�	
					hash.put(word, 1);	// key �� �ٰ��� word value �� �ٰ��� 1�� ����ִ´�.
				}
			}
			line = in.readLine();
			
		}
		in.close();
	} catch (IOException e) {
		System.out.println(e);
	}
	
	System.out.println("I \t:" + hash.get("I"));
	System.out.println("YOU \t:" + hash.get("YOU"));
	System.out.println("HE \t:" + hash.get("HE"));
	System.out.println("BRUTUS \t:" + hash.get("BRUTUS"));
	System.out.println("EVIL \t:" + hash.get("EVIL"));
	System.out.println("THE \t:" + hash.get("THE"));
	System.out.println("AND \t:" + hash.get("AND"));
}
	
	
}
