class Solution {
    public boolean isBipartite(int[][] graph) {
      int vis[]= new int[graph.length];

      for(int i=0;i<graph.length;i++)
      {
          if(vis[i]==0)
          {
            boolean res=isBip(i,-1,vis,graph);
            if(!res)return false;
          }
      }  
      return true;
    }
    public boolean isBip(int ele,int parentColor,int vis[],int[][] graph)
    {
        if(vis[ele]==0)
        {
            vis[ele]=-parentColor;
            for(int i : graph[ele])
            {
                boolean res=isBip(i,vis[ele],vis,graph);
                if(!res)return false;
            }
        }
        else if(vis[ele]==parentColor)return false;
        return true;
    }
}