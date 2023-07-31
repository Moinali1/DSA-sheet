class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dis[]= new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[S]=0;
        boolean vis[]= new boolean[V];
    
        pq.add(new int[]{S,0});
        
        while(!pq.isEmpty())
        {
            int node[]= pq.remove();
            int ele=node[0];
            int elecost=node[1];
            
            if(!vis[ele])
            {
                vis[ele]=true;
                for(ArrayList<Integer> childlist :adj.get(ele))
                {
                        int childele=childlist.get(0);
                        int childcost=childlist.get(1);
                        if(dis[childele]>elecost+childcost)
                        {
                            dis[childele]=elecost+childcost;
                            pq.add(new int[]{childele,dis[ele]+childcost});
                        }
                }
            }
        }
        return dis;
    }
}