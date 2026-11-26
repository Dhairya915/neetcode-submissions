class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
        int k = 2;

        int[][] dp = new int[n + 1][k + 1];

        for (int j = 0; j <= k; j++) {
            dp[n][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {

                if (j == 2) {
                    int buy = dp[i + 1][1] - prices[i];
                    int skip = dp[i + 1][2];

                    dp[i][j] = Math.max(buy, skip);
                } else {
                    int sell = dp[i + 1][2] + prices[i];
                    int skip = dp[i + 1][1];

                    dp[i][j] = Math.max(sell, skip);
                }
            }
        }

        return dp[0][k];   
    }
}