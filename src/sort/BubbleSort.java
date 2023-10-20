package sort;

public class BubbleSort {

	private static int[] arrayUnsorted = { 13, 2, 8, 3, 59, 76, 67, 1 };

	public static void main(String args[]) {
		System.out.println("Hello World");

		arrayUnsorted = bubbleSort(arrayUnsorted);

		for (int i = 0; i < arrayUnsorted.length; i++) {
			System.out.println(arrayUnsorted[i]);
		}
	}

	public static int[] bubbleSort(final int[] n) {
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n.length - 1; j++) {
				if (n[j] > n[j + 1]) {
					final int local = n[j + 1];
					n[j + 1] = n[j];
					n[j] = local;
				}
			}
		}

		return n;
	}
}
