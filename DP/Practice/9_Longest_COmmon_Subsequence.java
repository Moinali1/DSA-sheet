class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int dp[][]= new int[t1.length()+1][t2.length()+1];

        for(int i=1;i<=t1.length();i++)
            for(int j=1;j<=t2.length();j++)
            {
                if(t1.charAt(i-1)==t2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
            }
        return dp[t1.length()][t2.length()];    
    }
}


// class Solution {
//     public int longestCommonSubsequence(String t1, String t2) {
//         int dp[][]= new int[t1.length()+1][t2.length()+1];

//         for(int i=0;i<=t1.length();i++)
//             for(int j=0;j<=t2.length();j++) dp[i][j]=-1;

//         return lcs(t1,t2,t1.length(),t2.length(),dp);
//     }
//     int lcs(String t1,String t2,int m,int n,int dp[][])
//     {
//         if(n==0 || m==0)return 0;

//         if(dp[m][n]!=-1)return dp[m][n];

//         if(t1.charAt(m-1)== t2.charAt(n-1))
//         {
//             dp[m][n]=1+lcs(t1,t2,m-1,n-1,dp);
//         }
//         else dp[m][n]=Math.max(lcs(t1,t2,m-1,n,dp),lcs(t1,t2,m,n-1,dp));

//         return dp[m][n];
//     }
// }