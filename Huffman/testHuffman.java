
package huffmantree;


import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.StringTokenizer;


import javax.swing.plaf.synth.SynthSpinnerUI;



public class testHuffman {	

	
	public static void main(String[] args) {
	
		
		
		HeapPriorityQueue queue = new HeapPriorityQueue();
		
		String[] word = new String[100];	
		int[] wordinline= new int[10];		
		int nextword = 0;				
		int lineNum =0;					
		try {
			BufferedReader in = new BufferedReader(new FileReader("Huffman.txt"));
			String line = in.readLine();
			
			while (line != null) {				
				int a = nextword;
				StringTokenizer parser = new StringTokenizer(line, " .,:;-?!");				
				
				while (parser.hasMoreTokens()) {
					String temp = parser.nextToken().toUpperCase();
					word[nextword] = temp;					
					nextword++;
					
					
				}
				
				lineNum++;
				wordinline[lineNum] = nextword -a;							
				line = in.readLine();
			}
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		int[] alphabetArray = new int[26];
		
		for (int j = 0; j < nextword; j++) {
			String input = word[j];
			
			for (int i = 0; i < input.length(); i++) {
				
				char ch = input.charAt(i);
				
				int value = (int) ch;
				
				if (value >= 65 && value <= 90) {
					alphabetArray[(ch - 'A')]++;
					
				}
			}
		}

		System.out.println("<<<< Frequency >>>>");
		
		for (int i = 0; i < alphabetArray.length; i++) {
			
			if (alphabetArray[i] > 0) {
				char ch = (char) (i + 65);
				queue.add(new Huffman().new trecord(ch, alphabetArray[i]));
				System.out.println(ch + "  : " + alphabetArray[i]);

			}
		}
		
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
