// https://leetcode.com/problems/network-delay-time/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++)adj.add(new ArrayList<>());

        for(int[] node:times)
        {
            adj.get(node[0]).add(new int[]{node[1],node[2]});
        }
        int dis[]= new int[n+1];
        boolean vis[]= new boolean[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE); dis[k]=0;
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);//{node,pretime}
        pq.add(new int[]{k,0});

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

        int maxOfAll=0;
        for(int i=1;i<=n;i++)maxOfAll=Math.max(maxOfAll,dis[i]);

        return maxOfAll==Integer.MAX_VALUE?-1:maxOfAll;


    }
}









