import java.util.*;
public class LabAssignment3 {
	public static void main (String[] args){
		int[] c = new int[10]; 
		int[] copy = new int[10];
		Random rand = new Random();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> dcopy = new ArrayList<Integer>();
		ArrayList<Integer> step4 = new ArrayList<Integer>();
		int x = 0;
		c = new int [10];
		int i = 0;
/*Part 1: Integer Arrays*/
/*Step2*/
		while(i < c.length){ //Loop through to assign random number to each index.
			c[i] = rand.nextInt(100);
			i++;
	    }
/*Step 2 for ArrayList*/	
		for(int s = 0; s < 10; s++){
			d.add(rand.nextInt(100));
		}
/*Step 3*/		
		for(int j = 0; j< c.length; j++){ //Print each statement
			//System.out.print(c[j] + " ");
		}
		System.out.println();
/*Step 3 for ArrayList*/
		int w = 0;
		while(w < d.size()){
			//System.out.print(d.get(w) + " ");
			w++;
		}
		System.out.println();
/*Step 4*/
		for(int z = 0; z < copy.length; z++){
			copy[z] = c[z];
		}
		Arrays.sort(copy);
/*Step 4 for ArrayList*/
		dcopy.addAll(d);
		Collections.sort(dcopy);
/*Step 5*/
		while(x < copy.length){ //Print each statement of Copy
			//System.out.print(copy[x] + " ");
			x++;
		}
		System.out.println();
/*Step 5 for ArrayList*/
		int m = 0;
		while(m < 10){ //Print each statement of dcopy
			//System.out.print(dcopy.get(m) + " ");
			m++;
		}
		System.out.println();
/*Part 2 Step 4*/
		for(int b = 0; b < 100; b++){
			step4.add(rand.nextInt(100));
			Collections.sort(step4);
			System.out.print(step4.get(b) + " ");
		}
		System.out.println();
		System.out.println(sequentialSearch(step4, 1));
		System.out.println(binarySearch(step4, 1));
		System.out.println(sequentialSearch(step4, 20));
		System.out.println(binarySearch(step4, 20));
		System.out.println(sequentialSearch(step4, 50));
		System.out.println(binarySearch(step4, 50));
		System.out.println(sequentialSearch(step4, 75));
		System.out.println(binarySearch(step4, 75));
		System.out.println(sequentialSearch(step4, 100));
		System.out.println(binarySearch(step4, 100));
     }
/*Part 2: Searching*/
/*Step 1*/
	public static int sequentialSearch(ArrayList<Integer>list, int value){
		int l = 0;
		int scount = 0;
		while(l < list.size()){
			scount++;
			if(list.get(l) == value){
/*Step 3*/
			System.out.println("Number of Comparisons Using Sequential Search: " + scount);
			return l;
			}
			l++;
			
		}
/*Step 3*/
		System.out.println("Number of Comparisons Using Sequential Search: " + scount);
		return -1;
	}
/*Step 2*/
	public static int binarySearch(ArrayList<Integer>list, int value){
		int low = 0;
	    int high = list.size()-1;
	    int bcount = 0; 
	    for(int index = 0; index < list.size(); index++){
	    	while(low<=high){
	    	int middle = (low + high)/2;
	         if(value == list.get(middle)) {
	        	bcount++;
/*Step 3*/
	        	System.out.println("Number of Comparisons Using Binary Search: " + bcount);
	            return middle;
	         }
	         else if(value < list.get(middle)){
	            high = middle - 1;
	            bcount++;
	         }
	         else if(value > list.get(middle)){
	        	low = middle + 1;
	        	bcount++;
	         }
	    	}
	    }
/*Step 3*/	
	    System.out.println("Number of Comparisons Using Binary Search: " + bcount);
		return -1;	
	}
}
/*
 * 85 85 85 85 85 85 85 85 90 90 90 90 90 90 90 90 90 90 92 92 92 92 92 92 92 92 92 92 92 92 92 92 92 92 92 92 97 97 97 97 97 97 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 99 
 * Searches using 1
 Number of Comparisons Using Sequential Search: 1
0
Number of Comparisons Using Binary Search: 6
0
 * Searches using 20
Number of Comparisons Using Sequential Search: 100
-1
Number of Comparisons Using Binary Search: 7
-1
 * Searches using 50
Number of Comparisons Using Sequential Search: 52
51
Number of Comparisons Using Binary Search: 7
51
 * Searches using 75
Number of Comparisons Using Sequential Search: 82
81
Number of Comparisons Using Binary Search: 6
81
 * Searches using 100
Number of Comparisons Using Sequential Search: 100
-1
Number of Comparisons Using Binary Search: 7
-1

 */
