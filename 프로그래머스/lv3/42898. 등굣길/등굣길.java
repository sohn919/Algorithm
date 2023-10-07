class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int[] puddle : puddles) {
            dp[puddle[1]-1][puddle[0]-1] = Integer.MAX_VALUE;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                if (i>=1 && dp[i-1][j] != Integer.MAX_VALUE) {
                    dp[i][j] += dp[i-1][j];
                }
                if (j>=1 && dp[i][j-1] != Integer.MAX_VALUE) {
                    dp[i][j] += dp[i][j-1];
                }
                dp[i][j] %= 1_000_000_007;
            }
        }
        answer = dp[n-1][m-1];
        return answer;
    }
}