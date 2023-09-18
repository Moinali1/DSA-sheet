class Solution {
    public int longestPalindromeSubseq(String s) {
       int dp[][]= new int[s.length()+1][s.length()+1];

        for(int i=0;i<=s.length();i++)dp[i][i]=1;
        
        for(int i=s.length();i>=0;i--)
        {
            for(int j=i+1;j<s.length();j++)
            {
                 if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=2+dp[i+1][j-1];
                 else{
                     dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                 }   
            }
        }
        return dp[0][s.length()-1]; 
    }
}


//top down
class Solution {
    public int longestPalindromeSubseq(String s) {
        int dp[][]= new int[s.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++)
        {
            for(int j=0;j<=s.length();j++)
            {
                dp[i][j]=-1;
            }
        }
        return lpsHelper(s,0,s.length()-1,dp);
    }
    public int lpsHelper(String s,int i,int j,int[][] dp)
    {
        if(j<i)return 0;
        if(i==j)return 1;

        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==s.charAt(j))
            dp[i][j]=2+lpsHelper(s,i+1,j-1,dp);
        
        else
            dp[i][j]=Math.max(lpsHelper(s,i+1,j,dp),lpsHelper(s,i,j-1,dp));
            
        return dp[i][j];
    }
}