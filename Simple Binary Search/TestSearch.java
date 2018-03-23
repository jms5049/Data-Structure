package HW02_Answer;

import java.util.Arrays;
import java.util.Random;

public class TestSearch {
	

	public static void main(String args[]){
		Random mRandom = new Random();
		Search mSearch = new Search();
		
		int size = 10000000;
		int randomInt[] = generateRandomIntArray(size);
		int testValue = randomInt[mRandom.nextInt(size)];
		
		performanceTest(mSearch, size, randomInt, testValue);
		

		
	}
	
	public static void performanceTest(Search mSearch, int size, int randomInt[], int testValue){
		long startTime, endTime, elapsedTime;
		
		System.out.println("데이터 크기 : " + size + " / 찾으려는 값 : " + testValue);
		
		System.out.println("***** 선형 탐색 *****");
		startTime = System.nanoTime();
		System.out.print("찾은 위치(index) : " + mSearch.linearSearch(randomInt, testValue)); 
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.print(" / 비교 횟수 : " + mSearch.getLinearSearchCount());
		System.out.println(" / 경과 시간 : " + elapsedTime / 1000000.0 + "ms");
		
		
		System.out.println("***** 이진 탐색 *****");
		Arrays.sort(randomInt);
		startTime = System.nanoTime();
		System.out.print("찾은 위치(index) : " + mSearch.binarySearch(randomInt, testValue)); 
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.print(" / 비교 횟수 : " + mSearch.getBinarySearchCount());
		System.out.println(" / 경과 시간 : " + elapsedTime / 1000000.0 + "ms");
	}

	public static int[] generateRandomIntArray(int size){
		int tempArr[] = new int[size];

		for(int i=0; i<size; i++){
			Random mRandom = new Random();
			tempArr[i] = mRandom.nextInt(size);
		}
		return tempArr;
	}
}
