package dp;

public class SubsetSumWithFactor {

	public static void main(String[] args) {
		int[] A = { 16, 4, 2, 7, 11, 1 };
		int b = 23;

		System.out.println(subsetSumWithFactor(A, b, A.length));
	}

	public static boolean subsetSumWithFactor(int[] A, int b, int n) {

		boolean[][] dp = new boolean[n + 1][b + 1];

		// For every element in the array you can have the sum 0
		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= b; j++) {
				if (A[i - 1] * 3 <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 3 * A[i - 1]] || dp[i][j] || dp[i - 1][j - 2 * A[i - 1]]
							|| dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
				} else if (A[i - 1] * 2 <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 2 * A[i - 1]] || dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
				} else if (A[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
				}

				dp[i][j] = dp[i][j] || dp[i - 1][j];
			}
		}

		return dp[n][b];
	}
}
