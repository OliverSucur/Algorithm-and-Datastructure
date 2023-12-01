package dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		int[] A = {1,5,2,3};
		int[] B = {1,4,2,5,6,2,5};
		
		int[][] dp = new int[A.length + 1][B.length + 1];
		
		for(int i = 0; i <= A.length; i++) {
			for(int j = 0; j <= B.length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
		
		int lcs = longestCommonSubsequence(A.length, B.length, A, B, dp);
		int twoOps = editDistanceWith2Ops("1523", "1425625");
		
		System.out.println(lcs);
		System.out.println(t);
	}
	
	public static int longestCommonSubsequence(int n, int m, int[] A, int[] B, int[][] dp) {
		if(B.length < A.length) {
			return 0;
		}
		
		//Base Case
		if(n == 0 || m == 0) {
			return 0;
		}
		if(dp[n][m] != Integer.MIN_VALUE) {
			return dp[n][m];
		}
		
		if(A[n - 1] == B[m - 1]) {
			dp[n][m] = 1 + longestCommonSubsequence(n - 1, m - 1, A, B, dp);
		} else {
			dp[n][m] =  Math.max(longestCommonSubsequence(n - 1, m, A, B, dp), longestCommonSubsequence(n, m - 1, A, B, dp));
		}
		
		return dp[n][m];
	}
	
	static int editDistanceWith2Ops(String X, String Y) {
        // Find LCS 
        int m = X.length(), n = Y.length();
        int L[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        int lcs = L[m][n];
 
        // Edit distance is delete operations + 
        // insert operations. 
        return (m - lcs) + (n - lcs);
    }
}
