class Solution
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Stack<Integer> st= new Stack<Integer>();
        boolean vis[]= new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                getTopo(i,V,vis,adj,st);
                st.add(i);
            }
        }
        int[] ans= new int[V];
        for(int i=0;i<V;i++)ans[i]=st.pop();
        return ans;
    }
    static void getTopo(int ele,int V,boolean[] vis, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st)
    {
        vis[ele]=true;
        for(int i=0;i<adj.get(ele).size();i++)
        {
            if(!vis[adj.get(ele).get(i)]){
                getTopo(adj.get(ele).get(i),V,vis,adj,st);
                st.add(adj.get(ele).get(i));
            }
        }
    }
}