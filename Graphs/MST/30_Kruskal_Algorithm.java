// To find the minimum spanning tree
class Solution{
    static class Disjoint{
        int V;
        int[] rank;
        int[] parent;
        
        Disjoint(int V)
        {
            this.V=V;
            rank= new int[V];parent= new int[V];
            for(int i=0;i<V;i++)
                parent[i]=i;
        }
        
        int findPrnt(int node)
        {
            if(node==parent[node])return node;
            return parent[node]=findPrnt(parent[node]);
        }
        
        void unionByRank(int u,int v)
        {
            int uni_U=findPrnt(u),uni_V=findPrnt(v);
            int uRank=rank[uni_U],vRank=rank[uni_V];
            
            if(uRank>vRank) parent[uni_V]=uni_U;
            else if(vRank>uRank)parent[uni_U]=uni_V;
            else{
                parent[uni_V]=uni_U;
                rank[uni_U]++;
            }
        }
    }
    
	static int spanningTree(int V, int E, int edges[][]){
	    Disjoint ds= new Disjoint(V);
	    Arrays.sort(edges,(a,b)->a[2]-b[2]);
	    
	    int ans=0;
	    for(int[] e:edges)
	    {
	        if(ds.findPrnt(e[0])!=ds.findPrnt(e[1]))
	        {
	            ds.unionByRank(e[0],e[1]);
	            ans+=e[2];
	        }
	    }
	    return ans;
	   
	}
}








