
https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

// Bottom up
class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        
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


// Top Down Approach
class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp= new int[N+1][sum+1];
        
         for (int i = 1; i <= N; i++) 
             for (int w = 1; w <= sum; w++) 
                    dp[i][w] = -1;
        
        return getSubSum(arr,sum,N,dp)==sum;
    }
    
    static int getSubSum(int[] arr,int sum,int idx,int dp[][]){
        if(idx==0 || sum==0)return 0;
        
        if(dp[idx][sum]!=-1)return dp[idx][sum];
        
        int incl=0;
        if(sum>=arr[idx-1])incl=arr[idx-1]+getSubSum(arr,sum-arr[idx-1],idx-1,dp);
        int excl= getSubSum(arr,sum,idx-1,dp);
        
        dp[idx][sum]=Math.max(incl,excl);
        
        return dp[idx][sum];
    }
}


