class Solution {
    public int solution(int m, int n, int[][] puddles) {
                 int answer = 0;
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int i=0; i<puddles.length; i++) {
            dp[puddles[i][0]][puddles[i][1]] = Integer.MAX_VALUE;
        }
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;
                if (dp[i-1][j] != Integer.MAX_VALUE) {
                    dp[i][j] += dp[i-1][j];
                }
                if (dp[i][j-1] != Integer.MAX_VALUE) {
                    dp[i][j] += dp[i][j-1];
                }
                dp[i][j] %= 1_000_000_007;
            }
        }
        answer = dp[m][n];
        return answer;
    }
}