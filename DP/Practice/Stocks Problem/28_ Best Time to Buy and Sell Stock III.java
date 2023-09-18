class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp= new int[prices.length+1][2][3];

        for (int ind = n - 1; ind>= 0; ind--) {
            for (int buy=1; buy >= 0; buy--) {
                for (int cap = 2; cap>= 1; cap--) {
                    if (buy == 0) {
                        dp[ind][buy][cap] =
                        Math.max ( -prices[ind] + dp[ind + 1][1][cap],
                                               0 + dp[ind+1] [0] [cap]);
                    }
                    else
                        dp[ind] [buy ] [cap] =
                        Math.max(prices[ind] + dp[ind + 1][0][cap-1],
                                           0 + dp[ind+1][1][cap]);
                    }
            }
        }
        return dp[0][0][2];
    }
}



// top down 3d dp
class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp= new int[prices.length+1][2][3];

        for(int i=0;i<prices.length;i++)
            for(int j=0;j<2;j++)
                for(int k=0;k<3;k++)
                    dp[i][j][k]=-1;
        //considering 0 as true here and 1 as false
        return getProfit(0,0,2,prices,dp) ;
    }
    public int getProfit(int idx,int buySell,int transLeft,int[] prices,int[][][] dp)
    {
        if(idx==prices.length || transLeft==0)return 0;
        if(dp[idx][buySell][transLeft]!=-1)return dp[idx][buySell][transLeft];

        if(buySell==0)
        {
            dp[idx][buySell][transLeft]=Math.max(-prices[idx]+getProfit(idx+1,1,transLeft,prices,dp),0+getProfit(idx+1,0,transLeft,prices,dp));
        }
        else
        {
            dp[idx][buySell][transLeft]=Math.max(prices[idx]+getProfit(idx+1,0,transLeft-1,prices,dp),0+getProfit(idx+1,1,transLeft,prices,dp));
        }
        return dp[idx][buySell][transLeft];
    }
}