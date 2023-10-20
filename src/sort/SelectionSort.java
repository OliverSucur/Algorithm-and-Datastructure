package sort;

public class SelectionSort {

	private static int[] arrayUnsorted = {13,2,8,3,59,76,67,1};

	public static void main(String[] args) {
		arrayUnsorted = selectionSort(arrayUnsorted);
		
		for(int i = 0; i < arrayUnsorted.length; i++) {
			System.out.println(arrayUnsorted[i]);
		}
	}
	
	public static int[] selectionSort(final int[] n) {
		int min = 0;
		int index = 0;
		int local = 0;
		
		for(int i = 0; i < n.length; i++) {
		    index = 0;
			min = n[i];
			
			for(int j = i; j < n.length - 1; j++) {
				if(n[j] > n[j+1]) {
					min = n[j+1];
					index = j+1;
				}
			}
			
			local = n[i];
			n[i] = min;
			n[index] = local;
		}
		
		return n;
	}
}
