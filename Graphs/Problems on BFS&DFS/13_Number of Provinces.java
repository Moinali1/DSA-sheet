class Solution {
    public int findCircleNum(int[][] graph) {
        boolean vis[]= new boolean[graph.length+1];
        int ans=0;
        for(int i=1;i<=graph.length;i++)
        {
            if(!vis[i])
            {
                cntComponent(i,vis,graph);
                ans++;
            }
        }
        return ans;
    }
    public void cntComponent(int ele,boolean vis[],int[][] graph)
    {
        if(vis[ele])return;
        vis[ele]=true;
        for(int i=0;i<graph.length;i++)
        {
            if(graph[ele-1][i]==1 && !vis[i+1])
            {
                cntComponent(i+1,vis,graph);
            }
        }
    }
}