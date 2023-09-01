class Solution{

    public int countPartitions(int N, int d, int arr[]){
       int arrsum=0;int mod=1000000007;
       for(int i:arr)arrsum+=i;
       int sum=(arrsum+d);
       
       if(sum%2!=0)return 0;
       sum=sum/2;
       
       
	   int[][] dp= new int[N+1][sum+1];
       
       dp[0][0]=1;
       
       for(int i=1;i<=N;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                int incl=0;
                if(j>=arr[i-1])incl=dp[i-1][j-arr[i-1]]%mod;
                int excl=dp[i-1][j]%mod;
                
                dp[i][j]=(incl+excl)%mod;
            }
        }
        
        return dp[N][sum]%mod;
    }
}