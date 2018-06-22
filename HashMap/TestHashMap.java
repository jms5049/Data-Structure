import java.util.HashMap;	//hashmap import
import java.util.StringTokenizer;
import java.io.*;

public class TestHashMap {

	public static void main(String[] args) {
	
	int a = 0;
	HashMap hash = new HashMap();
	// HashMap 객체 생성
	
	//input이라는 파일을 한줄 한줄 일어온뒤
	//그 한줄 한줄을 .,;: ?! 들어간 곳마다 잘라 단어 단위로 만든뒤, 그 단어들을 key값으로 넣어주고, value는 1로 넣어준다.
	try {
		BufferedReader in = new BufferedReader(new FileReader("Caesar.txt"));
		String line = in.readLine();
		
		while (line != null) {
			
			StringTokenizer parser = new StringTokenizer(line, " .,:;-?!");

			while (parser.hasMoreTokens()) {
				String word = parser.nextToken().toUpperCase();
							
				if(hash.containsKey(word)){	//word가 해쉬테이블에 이미 존재한다면
					a=(int) hash.get(word);	// 그 value를 a로 받는다
					a++;	// a를 1만큼 증가시킨다
					hash.put(word, a);	//증가시킨 a를 다시 해쉬테이블에 넣어준다
				}
				else{	//존재하지 않다면	
					hash.put(word, 1);	// key 에 다가는 word value 에 다가는 1을 집어넣는다.
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
