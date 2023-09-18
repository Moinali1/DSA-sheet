// https://www.codingninjas.com/studio/problems/print-longest-common-subsequence_8416383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class Solution {
    public static String findLCS(int n, int m, String s1, String s2){
        int dp[][]= new int[n+1][m+1];

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }   

        int i=n,j=m;
        String ans="";
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                ans=s1.charAt(i-1)+ans;
                i--;j--;
            }
            else
            {
                if(dp[i-1][j]>dp[i][j-1])i--;
                else j--;
            }
        }
        return ans;
    }
}

