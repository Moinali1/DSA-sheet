class Solution {
    public boolean canFinish(int n, int[][] prereq) {
       ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
       for(int i=0;i<n;i++)adj.add(new ArrayList());
       for(int[] i:prereq) adj.get(i[1]).add(i[0]);

        boolean vis[]= new boolean[n];
        boolean rec[]= new boolean[n];
        
    for(int i=0;i<n;i++)if(!vis[i]) 
    {
        boolean ans=canFinished(vis,rec,adj,i);
        if(!ans)return false;
    }
    return true;
    }
    public boolean canFinished(boolean vis[],boolean rec[], ArrayList<ArrayList<Integer>> adj,int ele)
    {
        if(rec[ele])return false;
        if(vis[ele])return true;
        vis[ele]=true; rec[ele]=true;
        for(int i=0;i<adj.get(ele).size();i++)
        {
            boolean res=canFinished(vis,rec,adj,adj.get(ele).get(i));
            if(!res)return false;
        }
        rec[ele]=false;
        return true;
    }
}