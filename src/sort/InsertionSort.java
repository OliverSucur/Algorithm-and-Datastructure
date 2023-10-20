package sort;

public class InsertionSort {

	private static int[] arrayUnsorted = { 13, 2, 8, 3, 59, 76, 67, 1 };

	public static void main(String[] args) {
		int[] sorted = insertionSort(arrayUnsorted);
		
		for (int i = 0; i < arrayUnsorted.length; i++) {
			System.out.println(sorted[i]);
		}
	}

	public static int[] insertionSort(final int[] arr) {
		int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];

            for(int j = i - 1; i >= 0; i++) {
            	arr[j + 1] = arr[j];
                j--;
                arr[j + 1] = key;

            }
        }
        

        return arr;
	}

}
