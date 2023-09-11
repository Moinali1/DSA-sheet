class Solution{
    public int cutRod(int price[], int n) {
       int[] dp= new int[n+1];
       
       dp[0]=0;
       
       for(int i=1;i<dp.length;i++)
       {
           int maxofall=Integer.MIN_VALUE;
            for(int j=0;j<price.length;j++)
            {
                if(i>=(j+1))maxofall=Math.max(maxofall,price[j]+dp[i-(j+1)]);
            }
            dp[i]=maxofall;
       }
       
       return dp[n];
    }
}


// class Solution{
//     public int cutRod(int price[], int n) {
//         int[] dp= new int[n+1];
        
//         getMaxPrice(n,price,dp);
//         return dp[n];
//     }
//     public int getMaxPrice(int len,int[] price,int[]dp)
//     {
//         if(len==0)return dp[0]=0;
        
//         if(dp[len]!=0)return dp[len];
        
//         int maxofall=Integer.MIN_VALUE;
//         for(int i=price.length-1;i>=0;i--)
//         {
//             if(len>=i+1)
//                 maxofall=Math.max(maxofall,price[i]+getMaxPrice(len-(i+1),price,dp));
//         }
//         dp[len]=maxofall;
        
//         return dp[len];
        
//     }
// }