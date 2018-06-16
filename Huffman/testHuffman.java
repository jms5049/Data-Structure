
package huffmantree;


import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.StringTokenizer;


import javax.swing.plaf.synth.SynthSpinnerUI;



public class testHuffman {	

	
	public static void main(String[] args) {
	
		
		
		HeapPriorityQueue queue = new HeapPriorityQueue();
		
		/*********************파일 읽어 오기 및 줄과 단어로 구분*********************/
		
		String[] word = new String[100];	//구분한 단어들을 담을 문자형 배열
		int[] wordinline= new int[10];		//각 줄에 몇개의 단어가 있는 지 세서 그 개수를 담을 배열
		int nextword = 0;					//총 단어의 개수
		int lineNum =0;						//총 줄의 개수
		try {
			BufferedReader in = new BufferedReader(new FileReader("Huffman.txt"));
			String line = in.readLine();
			
			while (line != null) {				
				int a = nextword;
				StringTokenizer parser = new StringTokenizer(line, " .,:;-?!");				
				
				while (parser.hasMoreTokens()) {
					//단어를 위에 명시된 delimiter 대로 구분한 뒤 word라는 배열에 각각 넣어 준다.
					String temp = parser.nextToken().toUpperCase();
					word[nextword] = temp;					
					nextword++;
					
					
				}
				//여기서 각 줄에 몇개의 단어가 있는 지 그 연산을 한다.
				//5줄이라면 6개의 배열공간을 할당한 뒤 0번째 인덱스에는 0을 집어넣는다/
				//나중에 encode할 때 offset으로 쓰기 위함
				lineNum++;
				wordinline[lineNum] = nextword -a;							
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		/*******************파일 읽어 오기 및 줄과 단어로 구분 완료*******************/

		/*************************빈도수 테이블*************************/
		
		int[] alphabetArray = new int[26];
		// alphabet의 빈도수를 저장할 배열을 생성
		for (int j = 0; j < nextword; j++) {
			String input = word[j];
			// parser로 구분한 단어를 input에 하나씩 넣어준다
			for (int i = 0; i < input.length(); i++) {
				// 단어의 글자를 하나씩 본다
				char ch = input.charAt(i);
				// i번째 인덱스의 글자를 보여주는 함수
				int value = (int) ch;
				// ASCII 코드로 변환
				if (value >= 65 && value <= 90) {
					alphabetArray[(ch - 'A')]++;
					// ch의 ASCII code와 대문자 a의 차가 인덱스가 된다.
					// a -> 0 , b -> 1 ... 이런 식으로
				}
			}
		}

		System.out.println("<<<< Frequency >>>>");
		// alphabet의 빈도수를 출력한다
		for (int i = 0; i < alphabetArray.length; i++) {
			// 아예 출현하지 않은 alphabet은 출력하지 않는다
			if (alphabetArray[i] > 0) {
				char ch = (char) (i + 65);
				// ASCII code를 다시 문자로 변환
				queue.add(new Huffman().new trecord(ch, alphabetArray[i]));
				//알파벳과, 빈도수의 쌍을 우선순위히프큐에 삽입한다.
				System.out.println(ch + "  : " + alphabetArray[i]);

			}
		}
		
		/*************************빈도수 테이블 완료*************************/
		
		
		Huffman huff = new Huffman(queue);
		queue = huff.mergeTree();
		System.out.println("<<<< Huffman Code >>>>");
		huff.printcode();
		System.out.println();
		System.out.println("<<<< Text Encoding >>>>");
		huff.encode(word, nextword, wordinline, lineNum);	
		System.out.println("Total Encoded bit length = " + huff.bitlength());
	
	}
}