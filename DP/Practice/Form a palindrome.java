
class Solution{
    int findMinInsertions(String s){
         int dp[][]=new int[s.length()][s.length()];
        for(int[] i:dp)Arrays.fill(i,-1);
        return getMinInsert(s,0,s.length()-1,dp);
    }
    int getMinInsert(String s,int st,int end,int[][] dp)
    {
        if(st>=end)return 0;
        if(dp[st][end]!=-1)return dp[st][end];

        if(s.charAt(st)==s.charAt(end))
        {
            dp[st][end]=getMinInsert(s,st+1,end-1,dp);
        }
        else 
        {
            dp[st][end]=Math.min(1+getMinInsert(s,st,end-1,dp),1+getMinInsert(s,st+1,end,dp)); 
        }
        return dp[st][end];
    }
}