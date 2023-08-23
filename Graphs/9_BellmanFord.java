class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int dis[]=new int[V];
        
        Arrays.fill(dis,100000000);
        dis[S]=0;
        
        for(int i=0;i<V-1;i++)
        {
            for(ArrayList<Integer> edge:edges)
            {
                if(dis[edge.get(1)]>dis[edge.get(0)]+edge.get(2))dis[edge.get(1)]=dis[edge.get(0)]+edge.get(2);
            }
        }
        
            for(ArrayList<Integer> edge:edges)
            {
                if(dis[edge.get(1)]>dis[edge.get(0)]+edge.get(2))return new int[]{-1};
            }
        return dis;    
    }
}
