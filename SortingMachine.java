import java.util.ArrayList;
public class SortingMachine {
	int selectionCount = 0; // number of comparisons in selection sort
	int selectionExchange = 0; // number of exchanges in selection sort
	int bubbleCount = 0; // number of comparisons in bubble sort
	int bubbleExchange = 0; // number of exchanges in bubble sort
	int insertCount = 0; // number of comparisons in insertion sort
	int insertExchange = 0; // number of exchanges in insertion sort
	int newBubbleCount = 0; //number of comparisons in new bubble sort
	int newBubbleExchange = 0; //number of exchanges in new bubble sort
	public int[] bubbleSort(int[] a){	
		int temp;
		int size = a.length;
		for (int i = 0; i < size-1; i++)
		{
			for (int j = 0; j < size-(i+1); j++)
			{
				if (a[j] > a[j+1])				
				{ 
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					bubbleExchange++;
				}
				bubbleCount++;
			}
		}
		System.out.println("Number of Comparisons using Bubble Sort: " + bubbleCount);
		System.out.println("Number of Exchanges using Bubble Sort: " + bubbleExchange);
		return a;
	}

	
	public int[] selectionSort(int[] a){	
		int temp, min;
		int size = a.length;
		for (int i = 0; i < size; i++){		
			min = i; 
			for (int j = i + 1; j < size; j++) { 
				if (a[j] < a[min]) {
					min = j;
				} 
				selectionCount++;
			} 
			temp = a[min];
			a[min] = a[i];
			a[i] = temp;
			selectionExchange++;
		}
		System.out.println("Number of Comparisons using Selection Sort: " + selectionCount);
		System.out.println("Number of Exchanges using Selection Sort: " + selectionExchange);
		return a;
	}

	public int[] insertionSort(int[] a){	
		int temp;
		int size = a.length;
		for (int i = 1; i < size; i++){
			int j = i;
			temp = a[i];
			while (j > 0 && temp < a[j - 1]){
				a[j] = a[j - 1]; // right shifting
				j--;
				insertExchange++;
				insertCount++;
			}

			a[j] = temp;
		}
		System.out.println("Number of Comparisons using Insertion Sort: " + insertCount);
		System.out.println("Number of Exchanges using Insertion Sort: " + insertExchange);
		return a;
	}
	//Step 2a
	public int[] newBubbleSort(int[] a) {
		int temp;
		for(int i = a.length -1; i >= 1; i--){
			for(int j = a.length-(i+1); j>=1; j--){
				if(a[j-1] > a[j]){
					temp = a[j];
					a[j-1] = a[j];
					a[j] = temp;
					newBubbleExchange++;
				}
				newBubbleCount++;
			}
		}
		System.out.println("Number of Comparisons using new Bubble Sort: " + newBubbleCount);
		System.out.println("Number of Exchanges using new Bubble Sort: " + newBubbleExchange);
		return a;
	}
	//Step 3a
	   public static int[] newSelectionSort(int[] a){
			int temp;

			for (int i = a.length - 1; i >= 0; i--){		
				int max = i; 
				for (int j = i - 1; j >= 0; j--) { 
					if (a[max] < a[j]) {
						max = j;
					} 
					//selectionCount++;
				}
	         
				temp = a[max];
				a[max] = a[i];
				a[i] = temp;
			}
			return a;
		}
	//Step 3b
	public int[] revSelectionSort(int[] a){
		int temp;
		int max;
		for(int i = a.length-1; i >= 0; i-- ){
			max = i;
			for(int j = i -1; j >= 0; j--){
				if(a[max] > a[j] ) {
					max = j;
				}
			}
			temp = a[max];
			a[max] = a[i];
			a[i] = temp;
		}
		return a;
	}
	//Step 4a
	public int[] insertInOrder(ArrayList<Integer> a, int k){
		a.add(k);
		int array[] = new int[a.size()];
		for(int i = 0; i < array.length; i++){
			array[i] = a.get(i);
		}
		array = insertionSort(array);
		return array;
	}
	//Step 4b
	public int[] revInsertionSort (int[] a) {
		int temp;
		int j;
		for (int i = 1; i < a.length; i++){
			temp = a[i];
			for(j = i -1; (j>= 0) && (a[j]< temp); j--){
					a[j + 1] = a[j];
			}
			a[j+1] = temp;
			
	}
		return a;
	}
}
