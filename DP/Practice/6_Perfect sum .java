https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1

class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int dp[][]= new int[n+1][sum+1];
	    
	   // for(int i=1;i<=n;i++)dp[i][0]=1;
	    
	    for(int i=0;i<=n;i++)
	        for(int j=0;j<=sum;j++)
	            dp[i][j]=-1;
	    
        return countSum(sum,n,arr,dp)% 1000000007;	    
	} 
	public int countSum(int sum,int idx,int arr[],int[][] dp)
    {
        if(sum==0 && idx==0)return dp[idx][sum]=1;
        if(sum!=0 && idx==0)return dp[idx][sum]=0;
        
        if(dp[idx][sum]!=-1)return dp[idx][sum];
        
        int incl=0;
        if(sum>=arr[idx-1]) incl=countSum(sum-arr[idx-1],idx-1,arr,dp);
        int excl= countSum(sum,idx-1,arr,dp);
        
        dp[idx][sum]=(incl+excl)% 1000000007;
        return dp[idx][sum];
    }
}

//bottom up
class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int mod= 1000000007; 
	    int dp[][]=new int[n+1][sum+1];
    
       
        dp[0][0]=1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                int incl=0,excl=0;
                if(j>=arr[i-1])
                    incl=(dp[i-1][j-arr[i-1]])%mod;
                excl=dp[i-1][j]%mod;
                
                dp[i][j]=(incl+excl)%mod;
                
            }
        }
        return dp[n][sum]%mod;
	} 
}