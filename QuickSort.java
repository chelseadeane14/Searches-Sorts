import java.util.Random;


public class QuickSort {

	public static int compareCount=0;
	public static int swapCount=0;
	
	public static void main(String[] args) {
		Random generator = new Random(30);
		int[] testData10=new int[10];
		//generate random data
		for (int i=0; i<testData10.length;i++){
			int randomNumber=(int) (generator.nextDouble()*100) +1;
			testData10[i]=randomNumber;
		}
		
		//quickSort(testData10);
		int[] testData100=new int[100];
		//generate random data
		for (int i=0; i<testData100.length;i++){
			int randomNumber=(int) (generator.nextDouble()*100) +1;
			testData100[i]=randomNumber;
		}
		
		int[] testData1000=new int[1000];
		//generate random data
		for (int i=0; i<testData1000.length;i++){
			int randomNumber=(int) (generator.nextDouble()*100) +1;
			testData1000[i]=randomNumber;
		}
		//insertionSort(testData100, 0, testData100.length-1);
		//System.out.println("insertion sort completed with "+swapCount+" swap operations and "+compareCount+" comparisons");
		for(int i = 0; i < testData10.length; i++)
		{
			System.out.print(testData10[i] + " ");
		}
		System.out.println();
		
		
		
		
	}

	@SuppressWarnings("unused")
	private static void quickSort(int[] data) {
		//call recursive quick sort
		quickSort(data, 0, data.length-1);
	}

	private static void quickSort(int[] data, int min, int max) {
		if(min<max){
			if((max - min) < 9) {
				insertionSort(data, min, max + 1);
			}
			else{	
				//create partitions
				int indexOfPartition=partition(data, min, max);
			
				//recursively sort the partitions
				quickSort(data, min, indexOfPartition - 1);
				quickSort(data, indexOfPartition + 1, max);
			}
		}
		
	}

	private static int partition(int[] data, int min, int max) {
		int partitionElement;
		int left, right;
		int middle=(min+max)/2;
		
		//use the middle element as the partition value
		partitionElement=data[middle];
		
		//move the partition element to the start of the subarray	
		/**
		 * implement the swap method
		 */
		int temp = data[middle];
		data[middle] = data[min];
		data[min] = temp;
		swapCount++;
		
		left=min;
		right=max;
		while (left < right){
			compareCount++;
			//we want to find an element in the left that is > the partition element
			//compare elements starting from left to right, and increment left until a larger element is found
			while (data[left] <=partitionElement && left<max){
				compareCount++;
				left++;
			}
			/**
			 * Similarly, search for an element that is smaller than or equal to the partition element
			 * /decrement right until this element is found
			 */
			while (data[right] >= partitionElement && right > min){
				compareCount++;
				right--;
			}
			
			
			
			/**
			 * Swap the two elements if left is less than right (indices did not cross yet)
			 */
		    temp = data[left];
			data[left] = data[right];
			data[right] = temp;
			swapCount++;
			
			
			
		}
		/**
		 * The partition element was moved to the start of the array
		 * Now move it back to the middle by swapping the first element with the element at index "right"
		 */
		data[0] = data[right];
		data[right] = partitionElement;
		swapCount++;
		
		/**
		 * return the index of the partition element
		 */
		return right;
		
		
	}
	

	private static void insertionSort(int[] a, int min, int max){	
		int temp;
		for (int i = min + 1; i < max; i++){
			int j = i;
			temp = a[i];

			while (j > min && temp < a[j - 1]){
				a[j] = a[j - 1]; // right shifting
				j--;
				swapCount++;
				compareCount++; // temp <a[j-1] in the while loop
			}			
			a[j] = temp;
		}
	}

}