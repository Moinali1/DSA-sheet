class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis= new boolean[V];
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(!vis[i])getTraversal(ans,adj,vis,i);
        }
        return ans;
    }
    
    void getTraversal(ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int ele)
    {
        ans.add(ele);
        vis[ele]=true;
        for(int i=0;i<adj.get(ele).size();i++)
        {
            if(!vis[adj.get(ele).get(i)])
            {
                getTraversal(ans,adj,vis,adj.get(ele).get(i));
            }
        }
    }
}