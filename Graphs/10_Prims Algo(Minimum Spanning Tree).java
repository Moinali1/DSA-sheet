class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[2]-b[2]);
	    
	    ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
	    
	    for(int i=0;i<V;i++)adj.add(new ArrayList<>());
	    for(int[] edge: edges)
	    {
	        adj.get(edge[0]).add(new int[]{edge[0],edge[1],edge[2]});
	        adj.get(edge[1]).add(new int[]{edge[1],edge[0],edge[2]});
	    }
	   
	    pq.add(new int[]{0,0,0});
	    
	    boolean vis[]= new boolean[V];
	    int ans=0;
	    while(!pq.isEmpty())
	    {
	        int[] edge= pq.remove();
	        if(!vis[edge[1]]){
	            vis[edge[1]]=true;
	            ans+=edge[2];
	            for(int[] child: adj.get(edge[1]))
	            {
	                if(!vis[child[1]])pq.add(child);
	            }
	        }
	    }
	    return ans;
	    
	}
}