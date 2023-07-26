//recuresive TLE
//User function Template for Java


class Solution
{
    private final long MOD = 1000000007;
    
    private long add(long a,long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    
    private long multiply(long a,long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
    
    long countWays(int n,int k)
    {
        if(n==1)return k;
        if(n==2)return add(k,multiply(k,k-1))%MOD;
        
        long same= multiply(countWays(n-2,k),k-1)%MOD;
        long diff= multiply(countWays(n-1,k),k-1)%MOD;
        
        return add(same,diff);
    }
}

// dp[] memoization
class Solution
{
    private final long MOD = 1000000007;
    
    private long add(long a,long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    
    private long multiply(long a,long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
    
    long countWays(int n,int k)
    {
        long dp[]= new long[n+1];
        return getWays(n,k,dp);
    }
    long getWays(int n,int k,long dp[])
    {
        if(n==1)return k;
        if(n==2)return add(k,multiply(k,k-1))%MOD;
        
        if(dp[n]!=0)return dp[n];
        long same= multiply(countWays(n-2,k),k-1)%MOD;
        long diff= multiply(countWays(n-1,k),k-1)%MOD;
        
        dp[n]=add(same,diff);
        
        return dp[n];
    }
}


//bottom up
class Solution
{
    private final long MOD = 1000000007;
    
    private long add(long a,long b){
        return ((a%MOD) + (b%MOD))%MOD;
    }
    
    private long multiply(long a,long b){
        return ((a%MOD) * (b%MOD))%MOD;
    }
    
    long countWays(int n,int k)
    {
        long dp[]= new long[n+2];// for 1,17 case +1 more
        dp[1]=k;dp[2]=add(k,multiply(k,k-1));
        for(int i=3;i<=n;i++)
        {
            dp[i]=add(multiply(dp[i-2],k-1),multiply(dp[i-1],k-1));
        }
        return dp[n];
    }
    
}
