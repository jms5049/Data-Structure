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
		
		System.out.println("Data Size : " + size + " / Value to Find : " + testValue);
		
		System.out.println("***** Linear Search *****");
		startTime = System.nanoTime();
		System.out.print("Found At(index) : " + mSearch.linearSearch(randomInt, testValue)); 
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.print(" / No. of Comparison : " + mSearch.getLinearSearchCount());
		System.out.println(" / Time Taken : " + elapsedTime / 1000000.0 + "ms");
		
		
		System.out.println("***** Binary Search *****");
		Arrays.sort(randomInt);
		startTime = System.nanoTime();
		System.out.print("Found At(index) : " + mSearch.binarySearch(randomInt, testValue)); 
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.print(" / No. of Comparison : " + mSearch.getBinarySearchCount());
		System.out.println(" / Time Taken : " + elapsedTime / 1000000.0 + "ms");
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
