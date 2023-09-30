// https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

// arrroach 1
// 1-> take topo sort
// 2-> start relaxing vertex dis one by one according to topo

// dijkstra will take little more complexity use topo sort
//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int M, int[][] edges) {
	 ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int[] node:edges)
        {
            adj.get(node[0]).add(new int[]{node[1],node[2]});
        }
        int dis[]= new int[n];
        boolean vis[]= new boolean[n];
        Arrays.fill(dis,Integer.MAX_VALUE); dis[0]=0;
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);//{node,pretime}
        pq.add(new int[]{0,0});

        while(!pq.isEmpty())
        {
            int[] p=pq.remove();
            int node=p[0],preTime=p[1];

            if(!vis[node])
            {
                vis[node]=true;
                for(int i=0;i<adj.get(node).size();i++)
                {
                    int child=adj.get(node).get(i)[0],time=adj.get(node).get(i)[1];
                    if(dis[child]>preTime+time)
                    {
                        dis[child]=preTime+time;
                        pq.add(new int[]{child,preTime+time});
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++)if(dis[i]==Integer.MAX_VALUE)dis[i]=-1;

        return dis;
    }
}