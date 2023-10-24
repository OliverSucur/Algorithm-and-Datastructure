package sort;

public class MergeSort {

	private static int[] arrayUnsorted = { 13, 2, 8, 3, 59, 76, 67, 1 };

	public static void main(String[] args) {
		mergeSort(arrayUnsorted, 0, arrayUnsorted.length - 1);

		for (int i = 0; i < arrayUnsorted.length; i++) {
			System.out.println(arrayUnsorted[i]);
		}
	}

	private static void mergeSort(int[] A, int l, int r) {
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(A, l, m);
			mergeSort(A, m + 1, r);
			merge(A, l, m, r);
		}
	}

	private static void merge(int[] A, int l, int m, int r) {
		int[] B = new int[r - l + 1];
		int i = l;
		int j = m + 1;
		int k = 0;

		while (i <= m && j <= r) {
			if (A[i] < A[j]) {
				B[k] = A[i];
				i++;
			} else {
				B[k] = A[j];
				j++;
			}
			k++;
		}

		while (i <= m) {
			B[k] = A[i];
			i++;
			k++;
		}

		while (j <= r) {
			B[k] = A[j];
			j++;
			k++;
		}

		for (k = 0; k < B.length; k++) {
			A[l + k] = B[k];
		}
	}
}
