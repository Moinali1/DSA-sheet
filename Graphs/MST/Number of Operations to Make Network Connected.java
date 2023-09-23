class Solution {
    public int makeConnected(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
	    
	    for(int i=0;i<n;i++)adj.add(new ArrayList<>());
	    for(int[] edge: edges)
	    {
	        adj.get(edge[0]).add(edge[1]);
	        adj.get(edge[1]).add(edge[0]);
	    }
        boolean vis[]= new boolean[n];
        int edgeReq=0;
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(i,vis,adj);
                edgeReq++;
            }
        }
        edgeReq-=1;
        if(edgeReq==-1)return 0;
        int extraEdge=edges.length-(n-1);
        return extraEdge>=0?edgeReq:-1;

    }
    void dfs(int ele,boolean[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        vis[ele]=true;

        for(int i=0;i<adj.get(ele).size();i++)
        {
            if(!vis[adj.get(ele).get(i)])dfs(adj.get(ele).get(i),vis,adj);
        }
    }
}