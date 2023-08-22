class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;int N=arr.length;
        for(int i=0;i<N;i++)sum+=arr[i];
        if(sum%2!=0)return false; 
        sum=sum/2;
    
       int dp[][]=new int[N+1][sum+1];
        for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                int incl=0;
                if(j>=arr[i-1])incl=arr[i-1]+dp[i-1][j-arr[i-1]];
                int excl=dp[i-1][j];
                
                dp[i][j]=Math.max(incl,excl);
            }
        }
        return dp[N][sum]==sum;
        

    }
}