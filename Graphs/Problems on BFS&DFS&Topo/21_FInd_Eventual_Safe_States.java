
//dfs solution
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans= new ArrayList<>();
        boolean isSafe[]= new boolean[graph.length];
        boolean vis[]= new boolean[graph.length];

        for(int i=0;i<graph.length;i++)
            if(graph[i].length==0)isSafe[i]=true;

        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
            {
                boolean res=dfs(i,isSafe,vis,graph,ans);
            }    
        }
        Collections.sort(ans);
        return ans;
    }
    public boolean dfs(int ele,boolean[] isSafe,boolean[] vis,int[][] graph,List<Integer> ans)
    {
        if(vis[ele])
        {
            if(isSafe[ele])return true;
            else return false;
        }
        vis[ele]=true;

        boolean allTrue=true;
        for(int i=0;i<graph[ele].length;i++)
        {
            boolean res=dfs(graph[ele][i],isSafe,vis,graph,ans);
            if(!res)allTrue=false;
        }
        if(allTrue)
        {
            ans.add(ele);
            isSafe[ele]=true;
        }

        return allTrue;
    }
}
