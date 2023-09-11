

//unbounded knapsack approch
class Solution {
    public int coinChange(int[] coins, int amount) {
        int N=coins.length;
        int[][] dp = new int[N+1][amount + 1];
        
        for(int i=0;i<=N;i++)dp[i][0]=0;
        for(int j=1;j<=amount;j++)dp[0][j]=Integer.MAX_VALUE-1;
        
        for(int i=1;i<=N;i++)
            for(int j=1;j<=amount;j++)
            {
                if(j>=coins[i-1]) dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i-1]]+1);
                else dp[i][j]=dp[i-1][j];
            }

        return dp[N][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[N][amount];
    }
}


//Space Optimized
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n=coins.length;
//         int dp[]= new int[amount+1];
//         dp[0]=0;

//         for(int i=1;i<amount+1;i++)
//         {
//             int minfromall=Integer.MAX_VALUE;
//             for(int k=0;k<n;k++)
//             {
//                 if(i-coins[k]>=0)
//                 {
//                     if(dp[i-coins[k]]!=Integer.MAX_VALUE)
//                     minfromall=Math.min(minfromall,dp[i-coins[k]]+1);
//                 }
//             }
//             dp[i]=minfromall;
//         }
//         return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1; 
//     }
// }




// //Bottom Up
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n=coins.length;
//         int dp[]= new int[amount+1];
//         dp[0]=0;

//         for(int i=1;i<amount+1;i++)
//         {
//             int minfromall=Integer.MAX_VALUE;
//             for(int k=0;k<n;k++)
//             {
//                 if(i-coins[k]>=0)
//                 {
//                     if(dp[i-coins[k]]!=Integer.MAX_VALUE)
//                     minfromall=Math.min(minfromall,dp[i-coins[k]]+1);
//                 }
//             }
//             dp[i]=minfromall;
//         }
//         return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1; 
//     }
// }


// Top Down Approch

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int dp[]=new int[amount+1];
//         Arrays.fill(dp,-1);
        
//         int ans=minCoinReq(dp,coins,amount);
//         return ans!=Integer.MAX_VALUE?ans:-1;
//     }
//     public int minCoinReq(int dp[],int[] coins,int amt)
//     {
//         if(amt==0)
//         {
//             return 0;
//         }
//         if(amt<0)return Integer.MAX_VALUE;

//         if(dp[amt]!=-1)return dp[amt];
        
//         int minfromall=Integer.MAX_VALUE;
//         for(int i=0;i<coins.length;i++)
//         {
//             int cur=minCoinReq(dp,coins,amt-coins[i]);
//             if(cur!=Integer.MAX_VALUE)
//                 minfromall=Math.min(minfromall,cur+1);
//         }
//         dp[amt]=minfromall;
//         return dp[amt];
//     }
// }



// normal recursion TLE;

// class Solution {
//     int ans=Integer.MAX_VALUE;
//     public int coinChange(int[] coins, int amount) {
//         minCoinReq(coins,amount,0);
//         return ans!=Integer.MAX_VALUE?ans:-1;
//     }
//     public void minCoinReq(int[] coins,int amt,int coinCount)
//     {
//         if(amt==0)
//         {
//             ans=Math.min(ans,coinCount);
//             return;
//         }
//         if(amt<0)return;

//         for(int i=0;i<coins.length;i++)
//         {
//             minCoinReq(coins,amt-coins[i],coinCount+1);
//         }

//     }
// }