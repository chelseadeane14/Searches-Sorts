
import java.util.Random;


public class MergeSort {

	public static int compareCount=0;
	public static int copyCount=0;
	public static void main(String[] args) {
		
		Random generator = new Random(30);
		int[] testData10=new int[10];
		//generate random data
		for (int i=0; i<testData10.length;i++){
			int randomNumber=(int) (generator.nextDouble()*100) +1;
			testData10[i]=randomNumber;
		}
		
		
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
		
		
		mergeSort(testData1000, 0, testData1000.length-1);
		System.out.println("merge sort completed with "+copyCount+" copy operations and "+compareCount+" comparisons");
		
		
	}
	
	public static void mergeSort(int[] data){
		//call the recursive mergeSort method
		mergeSort(data, 0, data.length-1);
	}

	private static void mergeSort(int[] data, int startIndex, int endIndex) {

		// recursion condition
		if (startIndex<endIndex) {
			 if((endIndex - startIndex) < 9) {
				insertionSort(data, startIndex, endIndex + 1);
			}
			//else{
				//find index of middle element
				int midIndex= (startIndex+endIndex)/2;
			
				//recursive calls to sort each side
				mergeSort(data, startIndex, midIndex);
				mergeSort(data, midIndex+1, endIndex);
				
				if(data[midIndex] <= data[midIndex + 1]){
					compareCount++;
					return;
				}
			
				//merge the elements from each side of the array		
				merge(data, startIndex, midIndex, endIndex);
			//}	
		}
		
	}

	// Merge the elements of the array around the middle index. 
	private static void merge(int[] data, int min, int mid, int max) {
		
		//temporary array to hold the solution
		int[] temp=new int[data.length];
		
		//specify the starting points for each subarray
		int i=min;
		int j=mid+1;

		
		//index for updating temp
		int k=min;
		
		//copy smaller items from each subarray  into temp until one of the subarrays is exhausted		
		
		while (i<=mid &&  j<=max){
			/**
			 * compare the elements at index i and j
			 * copy the smallest element into temp
			 * increment i and j accordingly (only increment the index of the item that is copied)
			 * increment k
			 */
			
			if(data[i] < data[j]){
				temp[k] = data[i];
				copyCount++;
				k++;
				i++;
			}
			else{
				temp[k] = data[j]; 
				copyCount++;
				k++;
				j++;
			}
			compareCount++;
			
		}
		
		//copy remaining elements from the subarrays (if any) into temp
		while (i<=mid){
			/**
			 * copy the remaining items from the left subarray
			 */
			temp[k] = data[i];
			copyCount++;
			i++;
			k++;
		}

		while (j<=max){
			/**
			 * copy the remaining items from the right subarray
			 */
			temp[k] = data[j];
			copyCount++;
			j++;
			k++;
		}
		
		
		/**
		 * Copy the merged data from temp to the original array
		 */
			for(int h = 0; h < temp.length; h++){
				data[h] = temp[h];
			}
			copyCount++;
	}
	
	
	private static void insertionSort(int[] a, int min, int max){	
		int temp;
		for (int i = min+1; i < max; i++){
			int j = i;
			temp = a[i];
			compareCount++;
			while (j > min && temp < a[j - 1]){
				a[j] = a[j - 1]; // right shifting
				j--;
				copyCount++;
				compareCount++; // temp <a[j-1] in the while loop
			}			
			a[j] = temp;
		}
	}
	

}