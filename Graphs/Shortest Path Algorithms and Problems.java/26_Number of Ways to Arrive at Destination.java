class Solution {
    long MOD=1000000007;
    public int countPaths(int n, int[][] roads) {
     ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int[] node:roads)
        {
            adj.get(node[0]).add(new int[]{node[1],node[2]});
            adj.get(node[1]).add(new int[]{node[0],node[2]});
        }

        long dis[]= new long[n];
        long ways[]= new long[n];
        ways[0]=1;
        boolean vis[]= new boolean[n];
        Arrays.fill(dis,Long.MAX_VALUE); dis[0]=0;
        
        PriorityQueue<long[]> pq= new PriorityQueue<>((a,b)->(int)a[1]-(int)b[1]);//{node,pretime}
        pq.add(new long[]{0,0});

        
        while(!pq.isEmpty())
        {
            long[] p=pq.remove();
            int node=(int)p[0];long preTime=p[1];
            
            if(!vis[node])
            {
                vis[node]=true;
                for(int i=0;i<adj.get(node).size();i++)
                {
                    int child=(int)adj.get(node).get(i)[0];long time=adj.get(node).get(i)[1];
                    if(dis[child]>preTime+time)
                    {
                        dis[child]=preTime+time;
                        pq.add(new long[]{child,preTime+time});
                        ways[child]=ways[node]%MOD;
                    }
                    else if(dis[child]==preTime+time)
                    {
                        ways[child]=(ways[child]+ways[node])%MOD;
                    }
                }
            }
        }
        return (int)ways[n-1];
    }
}

