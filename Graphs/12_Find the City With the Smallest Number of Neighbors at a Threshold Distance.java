class Solution {
    public int findTheCity(int n, int[][] edges, int th) {
    int adj[][]= new int[n][n];

    for(int i=0;i<adj.length;i++)
            for(int j=0;j<adj.length;j++)
            {
                if(i==j)adj[i][j]=0;
                adj[i][j]=1000000;
            }

    for(int[] edge: edges)
            adj[edge[0]][edge[1]]= adj[edge[1]][edge[0]]=edge[2];


        for(int k=0;k<adj.length;k++)
            for(int i=0;i<adj.length;i++)
                for(int j=0;j<adj.length;j++)
                    if(i!=j)
                        adj[i][j]=Math.min(adj[i][j],adj[i][k]+adj[k][j]);
                    
        int maxCity=0,minCityCnt=Integer.MAX_VALUE,curCityCnt=0;
        for(int i=0;i<adj.length;i++)
            {
                for(int j=0;j<adj.length;j++)
                {
                    if(adj[i][j]<=th)curCityCnt++;
                }
                if(minCityCnt>=curCityCnt)
                {
                    minCityCnt=curCityCnt;
                    maxCity=i;
                }
                curCityCnt=0;
            } 
        return maxCity;      
    }
}