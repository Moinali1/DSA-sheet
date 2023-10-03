//https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
class Solution {
    final int MOD=100000;
    int minimumMultiplications(int[] arr, int start, int end) {
        int[] dis= new int[MOD];
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start,0});
        
        Arrays.fill(dis,Integer.MAX_VALUE); dis[start]=0;
        
        while(!pq.isEmpty())
        {
            int[] pair= pq.remove();
            int node=pair[0],preDis=pair[1];
                for(int i:arr)
                {
                    int newStart=(node*i)%MOD,newDis=preDis+1;
                    if(dis[newStart]>newDis)
                    {
                        dis[newStart]= newDis;
                        pq.add(new int[]{newStart,newDis});
                    }
            }    
        }
        return dis[end]==Integer.MAX_VALUE?-1:dis[end];
    }
}
