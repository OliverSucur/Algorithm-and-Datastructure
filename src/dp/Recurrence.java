package dp;

import java.util.Arrays;

public class Recurrence {
	static int b = 9;
	static int[] A = new int[b + 1];
	public static void main(String[] args) {
		for(int i = 1; i < 5; i++) {
			A[i] = i;
		}
		
		int result = recurrence(9);
		
		for(int i = 5; i < A.length; i++) {
			A[i] = 0;
		}
		
		int resultBottomUp = recurrenceBottomUp(9);
		
		System.out.println(resultBottomUp);
	}
	
	static int recurrence(int n) {
		if(n == 1 || n == 2 || n == 3 || n == 4) {
			return A[n];
		}
		if(Arrays.asList(A).contains(n)) {
			return A[n];
		}
		
		A[n] = recurrence(n - 1) + recurrence(n - 3) + 2*recurrence(n - 4);
		
		return A[n];
	}
	
	static int recurrenceBottomUp(int n) {
		if(n == 1 || n == 2 || n == 3 || n == 4) {
			return A[n];
		}
		
		for(int i = 5; i <= n; i++) {
			A[i] = A[i - 1] + A[i - 3] + 2 * A[i - 4];
		}
		
		return A[n];
	}
}
