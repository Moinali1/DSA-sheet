class Solution {
    public int change(int amount, int[] coins) {
        int N=coins.length;
        long[][] dp = new long[N+1][amount + 1];
        
        for(int i=0;i<=N;i++)dp[i][0]=1;
        
        for(int i=1;i<=N;i++)
            for(int j=1;j<=amount;j++)
            {
                if(j>=coins[i-1]) dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                else dp[i][j]=dp[i-1][j];
            }

        return (int)dp[N][amount];
    }
}
