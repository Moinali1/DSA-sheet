// https://practice.geeksforgeeks.org/problems/number-of-islands/1
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
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
         Disjoint ds =new Disjoint(rows*cols);
         int[][] graph= new int[rows][cols]; 
         List<Integer> res= new ArrayList<>();
         
         int dirs[][]={{-1,0},{0,1},{1,0},{0,-1}};
         int ans=0;
         for(int[]op: operators)
         {
             int row=op[0],col=op[1];
             
             if(graph[row][col]==1)
             {
                 res.add(ans);
                 continue;
             }
             
             graph[row][col]=1;
             int curNode=(row*rows)+col;
             ans++;
             for(int[] d: dirs)
             {
                int nearR=row+d[0],nearC=col+d[1];  
                if(isValid(nearR,nearC,graph) && graph[nearR][nearC]==1)
                {
                    int nearNode=(nearR*rows)+nearC;
                    if(ds.findPrnt(curNode)!=ds.findPrnt(nearNode))
                    {
                        ans--;
                        ds.unionByRank(curNode,nearNode);
                    }
                }
             }
            res.add(ans);
         }
        return res; 
    }
    boolean isValid(int row,int col,int[][] graph)
    {
        return row>=0 && row<graph.length &&col>=0 && col<graph[0].length;
    }
    
}