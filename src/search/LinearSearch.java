package search;

public class LinearSearch {

	private static int[] array = {1,3,2,5,6,6,7,8,3,2,3,5};
	
	public static void main(String[] args) {
		System.out.println(linearSearch(array, 8));
	}
	
	// Runtime: O(n)
	public static int linearSearch(final int[] n, int a) {
		final int length = n.length;
				
		for(int i = 0; i < length; i++) {
			if(n[i]  == a) {
				return i;
			}
		}
		
		throw new IllegalArgumentException("Number not found");
	}

}
