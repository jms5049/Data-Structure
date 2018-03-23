package HW02_Answer;

public class Search {
	private int linearSearchCount;
	private int binarySearchCount;
	
	public Search(){
		this.linearSearchCount = 0;
		this.binarySearchCount = 0;
	}
	
	public int getLinearSearchCount(){
		return this.linearSearchCount;
	}
	public int getBinarySearchCount(){
		return this.binarySearchCount;
	}
	

	public int linearSearch(int arr[], int x){
		int arrLength = arr.length;

		for(int i=0; i<arrLength; i++){
			if(arr[i] == x){
				return i;
			}
			else
				linearSearchCount++;
		}
		
		return -1;
	}
	
	public int binarySearch(int arr[], int x){
		int left, right, mid;
		
		left = 0; 
		right = arr.length - 1;	
	
		while(left <= right){
			mid = (left + right) / 2;
		
			/* Upper case */
			if(arr[mid] < x){
				left = mid;
				binarySearchCount++;
			}
			/* Lower Case */
			else if(arr[mid] > x){
				right = mid;
				binarySearchCount++;
				//System.out.println(right);
				
			}
			else{
				return mid;
			}	
			
		}
		return -1;
	}

}
