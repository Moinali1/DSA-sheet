class Solution {
    public int minDistance(String word1, String word2) {
        int len1=word1.length(); int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++)
          for(int j=0;j<=len2;j++) dp[i][j]=-1;

        return getMinDis(word1,word2,len1,len2,dp);
    }
    public int getMinDis(String s1,String s2,int i,int j,int[][] dp)
    {
      if(i==0 && j==0)return 0;
      if(i==0)return j;
      if(j==0)return i;

      if(dp[i][j]!=-1)return dp[i][j];

      if(s1.charAt(i-1)==s2.charAt(j-1))
            dp[i][j]=getMinDis(s1,s2,i-1,j-1,dp);
      else{
          dp[i][j]=Math.min((1+getMinDis(s1,s2,i,j-1,dp)),
                   Math.min((1+getMinDis(s1,s2,i-1,j,dp)),(1+getMinDis(s1,s2,i-1,j-1,dp)))
          );
      }      
      return dp[i][j];
    }
}