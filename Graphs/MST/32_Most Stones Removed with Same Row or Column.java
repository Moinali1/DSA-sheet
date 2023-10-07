class Solution {
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
            if(uni_U==uni_V)return;
            if(uRank>vRank) parent[uni_V]=uni_U;
            else if(vRank>uRank)parent[uni_U]=uni_V;
            else{
                parent[uni_V]=uni_U;
                rank[uni_U]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        int rowCnt=0,colCnt=0;
        for(int[] st:stones)
        {
            rowCnt=Math.max(rowCnt, st[0]);
            colCnt=Math.max(colCnt, st[1]);
        }
        Disjoint ds= new Disjoint(rowCnt+colCnt+2);//zero indexed thats why +2
        for(int[] st:stones)
        {
            ds.unionByRank(st[0],st[1]+rowCnt+1);
        }

        HashSet<Integer> parents= new HashSet<>();
        for(int[] st:stones)
        {
            int p1=ds.findPrnt(st[0]);
            int p2=ds.findPrnt(st[1]+rowCnt+1);
            parents.add(p1);parents.add(p2);
        }

        return stones.length-parents.size();//n-no. of components
    }
}