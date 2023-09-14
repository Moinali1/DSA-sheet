class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        dp=new int[cuts.length][cuts.length];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        Arrays.sort(cuts);    
        getMinCost(0,cuts.length-1,0,n,cuts);
        return dp[0][cuts.length-1];
    }
    public int getMinCost(int st,int end,int st_ele,int end_ele,int cuts[])
    {
        if(st>end)return 0;

        if(dp[st][end]!=-1)return dp[st][end];

        int cost=Integer.MAX_VALUE;
        for(int i=st;i<=end;i++)
        {
            int leftcost= getMinCost(st,i-1,st_ele,cuts[i],cuts);
            int rightcost= getMinCost(i+1,end,cuts[i],end_ele,cuts);
            cost=Math.min(cost, (end_ele-st_ele) +leftcost+rightcost);
        }
        dp[st][end]=cost;

        return dp[st][end];
    }

}