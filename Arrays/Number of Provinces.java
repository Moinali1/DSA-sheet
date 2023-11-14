class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
    boolean vis[]= new boolean[adj.size()+1];
        int ans=0;
        for(int i=1;i<=adj.size();i++)
        {
            if(!vis[i])
            {
                cntComponent(i,vis,adj);
                ans++;
            }
        }
        return ans;
    }
    public static void cntComponent(int ele,boolean vis[],ArrayList<ArrayList<Integer>> adj)
    {
        if(vis[ele])return;
        vis[ele]=true;
        for(int i=0;i<adj.size();i++)
        {
            if(adj.get(ele-1).get(i)==1 && !vis[i+1])
            {
                cntComponent(i+1,vis,adj);
            }
        }
    }
}