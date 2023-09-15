class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][]= new int[word1.length()+1][word2.length()+1];

        for(int i=1;i<=word1.length();i++)
            for(int j=1;j<=word2.length();j++)
                dp[i][j]=-1;

        return noOfDel(word1,word2,word1.length(),word2.length(),dp);
    }

    int noOfDel(String w1,String w2,int idx1,int idx2,int[][] dp)
    {
        if(idx1==0)return idx2;
        if(idx2==0)return idx1;
        
        if(dp[idx1][idx2]!=-1)return dp[idx1][idx2];

        if(w1.charAt(idx1-1)==w2.charAt(idx2-1))
        {
            dp[idx1][idx2]=noOfDel(w1,w2,idx1-1,idx2-1,dp);
        }
        else
        {
            dp[idx1][idx2]=Math.min(1+noOfDel(w1,w2,idx1,idx2-1,dp),1+noOfDel(w1,w2,idx1-1,idx2,dp));
        }

        return dp[idx1][idx2];
    }

}