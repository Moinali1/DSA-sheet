//more space optimized
class Solution {
    public int maxProfit(int[] prices) {
        int[] cur= new int[2];
        int[] ahead= new int[2];

        for(int i=prices.length-1;i>=0;i--)
        {
            for(int j=1;j>=0;j--)
            {
                if(j==0)
                    cur[0]=Math.max(-prices[i]+ahead[1],0+ahead[0]);
                else    
                    cur[1]=Math.max(prices[i]+ahead[0],0+ahead[1]);
            }
            ahead[0]=cur[0];
            ahead[1]=cur[1];
        }
        return cur[0];
    }
}

// bottom up
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length+1][2];

        for(int i=prices.length-1;i>=0;i--)
        {
            for(int j=1;j>=0;j--)
            {
                if(j==0)
                    dp[i][j]=Math.max(-prices[i]+dp[i+1][1],0+dp[i+1][0]);
                else    
                    dp[i][j]=Math.max(prices[i]+dp[i+1][0],0+dp[i+1][1]);
            }
        }
        return dp[0][0];
    }
}

// top down 
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length+1][2];

        for(int i=0;i<prices.length;i++)
            for(int j=0;j<2;j++)
                dp[i][j]=-1;
        //considering 0 as true here and 1 as false
        return getProfit(0,0,prices,dp);
    }
    public int getProfit(int idx,int buySell,int[] prices,int[][] dp)
    {
        if(idx==prices.length)return 0;
        if(dp[idx][buySell]!=-1)return dp[idx][buySell];

        if(buySell==0)
        {
            dp[idx][buySell]=Math.max(-prices[idx]+getProfit(idx+1,1,prices,dp),0+getProfit(idx+1,0,prices,dp));
        }
        else
        {
            dp[idx][buySell]=Math.max(prices[idx]+getProfit(idx+1,0,prices,dp),0+getProfit(idx+1,1,prices,dp));
        }
        return dp[idx][buySell];
    }
}