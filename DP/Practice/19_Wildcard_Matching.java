//bottom up
class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][]= new boolean[s.length()+1][p.length()+1];
        for(int i=1;i<=p.length();i++)
        {
            dp[0][i]=true;
            if(p.charAt(i-1)!='*'){dp[0][i]=false;break;}    
        }
        dp[0][0]=true;

        for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=p.length();j++)
            {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*')
                {
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }
                else dp[i][j]=false;
            }
        }
        return dp[s.length()][p.length()];
    }
}

// top down
// class Solution {
//     public boolean isMatch(String s, String p) {
//         boolean dp[][]= new boolean[s.length()+1][p.length()+1];
        // for(int i=0;i<=s.length();i++)
        // {
        //     for(int j=0;j<=p.length();j++)
        //         dp[i][j]=false;
        // }
//         return findIsMatch(s,p,s.length(),p.length(),dp);    
//         }

//     public boolean findIsMatch(String s,String p,int sIdx,int pIdx,boolean[][] dp)
//     {
//         if(sIdx==0 && pIdx==0)return true;
//         if(pIdx==0)return false;
//         if(sIdx==0){
//             for(int i=0;i<=pIdx-1;i++)
//                 if(p.charAt(i)!='*')return false;
//             return true;
//         }
//         if(dp[sIdx][pIdx])return true;

//         if(s.charAt(sIdx-1)==p.charAt(pIdx-1) || p.charAt(pIdx-1)=='?')
//             dp[sIdx][pIdx]=findIsMatch(s,p,sIdx-1,pIdx-1,dp);
//         else if(p.charAt(pIdx-1)=='*')
//         {
//             dp[sIdx][pIdx]=findIsMatch(s,p,sIdx,pIdx-1,dp) ||
//                            findIsMatch(s,p,sIdx-1,pIdx,dp);
//         }    
//         else dp[sIdx][pIdx]=false;
//         return dp[sIdx][pIdx];
//     }    
// }
