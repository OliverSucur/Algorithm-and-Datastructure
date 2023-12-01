package array;

public class MaximumSubset {

	public static void main(String[] args) {
		int[] B = new int[] { 1, 2, 3, 10, 12, 20, 30 };
		int[] A = new int[] { 5, 1, 12, 6, 9, 11, 8 };

		System.out.println(maxSubset(7, 4, B));
	}

	public static int maxSubset(int n, int k, int[] A) {
		mergeSort(A, 0, A.length - 1);

		return maxSubset(A, 0, n - 1, k);
	}

	private static int maxSubset(int[] A, int l, int r, int k) {
		if (l > r) {
			return 0;
		}

		if (l == r) {
			return 1;
		}

		int mid = (l + r) / 2;

		int LSS = maxSubset(A, l, mid - 1, k);
		int RSS = maxSubset(A, mid + 1, r, k);
		int CSS = maxCrossingSubset(A, l, mid, r, k);

		if (l >= mid && l != r) {
			if (A[r] - A[l] <= k) {
				RSS++;
			}
		} 
		if (l <= mid && l != r) {
			if (A[r] - A[l] <= k) {
				LSS++;
			}
		}

		int maxElements = 0;

		if (CSS >= LSS && CSS >= RSS) {
			maxElements = CSS;
		}
		if (RSS >= CSS && RSS >= LSS) {
			maxElements = RSS;
		}
		if (LSS >= CSS && LSS >= RSS) {
			maxElements = LSS;
		}

		System.out.println("LSS: " + LSS + " AND RSS: " + RSS + " AND CSS: " + CSS);
		return maxElements;
	}

	private static int maxCrossingSubset(int[] A, int l, int mid, int r, int k) {
		// Elements on the left side
		int leftElements = 0;

		if (A[mid] - A[l] <= k) {
			leftElements = mid - l + 1;
		}

		// Elements on the right side
		int rightElements = 0;

		if (A[r] - A[mid] <= k) {
			rightElements = r - mid + 1;
		}

		return rightElements > leftElements ? rightElements : leftElements;
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
