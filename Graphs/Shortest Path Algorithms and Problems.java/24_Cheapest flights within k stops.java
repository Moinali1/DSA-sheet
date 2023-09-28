class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int[] node:flights)
        {
            adj.get(node[0]).add(new int[]{node[1],node[2]});
        }

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);//{stops,node,pre distance}
        int[] dis= new int[n];

        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        pq.add(new int[]{0,src,0});

        while(!pq.isEmpty())
        {
            int[] nodeInfo= pq.remove();
            int stops=nodeInfo[0],node=nodeInfo[1],preDis=nodeInfo[2];
            if(stops<=k)
            {
                for(int i=0;i<adj.get(node).size();i++)
                {
                    int child=adj.get(node).get(i)[0],curdis=adj.get(node).get(i)[1];
                        if(dis[child]>preDis+curdis)
                        {
                            dis[child]=preDis+curdis;
                            pq.add(new int[]{stops+1,child,preDis+curdis});
                        } 
                }
            }
        }

        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];

    }
}