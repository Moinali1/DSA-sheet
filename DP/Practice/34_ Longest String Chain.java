class Solution {
    public int longestStrChain(String[] words) {
        int dp[][]= new int[words.length][words.length];
        Arrays.sort(words, (a,b)-> a.length()-b.length());
        return lsc(0,-1,dp,words);
    }
    public int lsc(int cur,int pre,int[][] dp,String[] words)
    {
        if(cur==dp.length)return 0;
        
        if(pre!=-1 && dp[cur][pre]!=0)return dp[cur][pre];

        int incl=0;
        if(pre==-1 || isPredecessor(words[pre],words[cur]))
        {
            incl=1+ lsc(cur+1,cur,dp,words);
        }
        int excl= lsc(cur+1,pre,dp,words);

        if(pre!=-1)dp[cur][pre]=Math.max(incl,excl);

        return Math.max(incl,excl);
    }

    public boolean isPredecessor(String pre,String cur)
    {
        int i=0,j=0,count=0;
        for(j=0;j<cur.length();j++)
        {
            if(i<pre.length() && pre.charAt(i)==cur.charAt(j))
                i++;
            else count++;    
        }
        return i==pre.length() && count==1;
    }

}