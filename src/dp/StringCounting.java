package dp;

public class StringCounting {

	public static void main(String[] args) {
		String s = "0110111101101101";

		System.out.println(stringCounting(s, s.length(), 2));
	}

	public static int stringCounting(String s, int n, int k) {
		char[] sAsChar = s.toCharArray();
		int[] bitString = new int[n];

		for (int i = 0; i < n; i++) {
			bitString[i] = Integer.parseInt(String.valueOf(sAsChar[i]));
		}

		int[][][] dp = new int[k + 1][n + 1][1];

		for (int i = 1; i < n; i++) {
			if (bitString[i] == 1 && bitString[i - 1] == 1) {
				dp[1][i][0] = dp[1][i - 1][0] + 1;
			} else {
				dp[1][i][0] = dp[1][i - 1][0];
			}

		}

		for (int i = 2; i <= k; i++) {
			for (int j = 2; j <= n; j++) {
				dp[i][j][0] = dp[i-1][j-1][0];
			}
		}

		if (dp[k][n][0] != -1) {
			return dp[k][n][0];
		}

		return 0;
	}

	public static int stringCountingMoreEfficent(String s, int n, int k) {
		char[] sAsChar = s.toCharArray();
		int[] bitString = new int[n];

		for (int i = 0; i < n; i++) {
			bitString[i] = Integer.parseInt(String.valueOf(sAsChar[i]));
		}

		int[][][] dp = new int[k + 1][n + 1][1];

		for (int i = 1; i <= n; i++) {
			if (bitString[i] == 1 && bitString[i - 1] == 1) {
				dp[1][i][0] = dp[1][i - 1][0] + 1;
			} else {
				dp[1][i][0] = dp[1][i - 1][0];

			}

		}

		if (dp[k][n][0] != -1) {
			return dp[1][n][0] - k + 1;
		}

		return 0;
	}
}
