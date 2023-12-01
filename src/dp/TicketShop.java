package dp;

public class TicketShop {

	public static void main(String[] args) {
		int D = 6;
		int[] A = { 2, 4, 2, 3, 1, 3, 3, 4, 3 };

		int result = minTicket(D, 0, A.length, A);
		System.out.println(result);
	}

	public static int minTicket(int D, int k, int n, int[] A) {
		if (D == 0)
			return 0;
		if (n == 0)
			return 0; // No tickets available

		int[][] dp = new int[n + 1][D + 1];

		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= D; j++) {
				dp[i][j] = 3092;
			}
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= D; j++) {
				dp[i][j] = 0;
			}
		}

		// Base case: With zero tickets you can reach zero distance
		for (int j = 0; j <= n; j++) {
			dp[j][0] = 0;
		}

		for (int l = 0; l <= k; l++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= D; j++) {
					if (A[i - 1] == j) {
						dp[i][j] = 1;
					} else if (A[i - 1] > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = Math.min(dp[i - 1][j - A[i - 1]] + 1, dp[i - 1][j]);
					}
				}
			}
		}

		int min = 3092;
		for (int i = 1; i <= n; i++) {
			if (dp[i][D] != 0) {
				min = Math.min(min, dp[i][4]);
			}
		}

		return min;

	}
}
