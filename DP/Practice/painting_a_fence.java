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
        long prev1=k,prev2=add(k,multiply(k,k-1));
        long cur=0;
        if(n==1)return prev1;
        if(n==2)return prev2;
        for(int i=3;i<=n;i++)
        {
            cur=add(multiply(prev2,k-1),multiply(prev1,k-1));
            prev1=prev2;
            prev2=cur;
        }
        return cur;
    }
    
}
