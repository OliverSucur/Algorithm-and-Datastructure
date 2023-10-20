package search;

public class BinarySearch {

	private final static int[] array = { 1, 3, 4, 5, 6, 7, 8, 12, 14, 22, 33, 41, 55 };

	public static void main(String[] args) {
		System.out.println(binarySearch(array, 0, array.length, 55));
	}

	// Runtime: O(log(n))
	public static int binarySearch(final int[] n, final int start, final int end, final int a) {
		int index = 0;
		int l = start;
		int r = end;

		while (n[index] != a) {
			index = (int) Math.floor((l + r) / 2); // integer would round it down, but mathematically it's supposed to
													// be floor

			if (n[index] == a) {
				return index;
			} else if (a < n[index]) {
				r = index - 1;
			} else {
				l = index + 1;
			}
		}

		return 0;
	}

}
