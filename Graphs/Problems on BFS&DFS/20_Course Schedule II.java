class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
       
       ArrayList<ArrayList<Integer>> adj= new ArrayList();
       for(int i=0;i<numCourses;i++)adj.add(new ArrayList());

       for(int[] i:pre)
            adj.get(i[1]).add(i[0]);
       
       boolean vis[]= new boolean[numCourses];
       boolean rec[]= new boolean[numCourses];
       Stack<Integer> st= new Stack<>();
       for(int i=0;i<numCourses;i++)
       {
           if(!vis[i]) 
           {
            boolean res=getTopo(i,st,vis,rec,adj);
            if(res)return new int[]{};
           }
       } 
       int ans[]= new int[numCourses];int k=0;
       while(!st.isEmpty())ans[k++]=st.pop();
       return ans;
    }
    // this function is giving us both the topo order as well as cl=kecking for cycle.
    public boolean getTopo(int ele,Stack<Integer> st,boolean vis[],boolean rec[],ArrayList<ArrayList<Integer>> adj)
    {
        if(rec[ele])return true;//cycle exist;
        if(vis[ele])return false;
        vis[ele]=true;
        rec[ele]=true;
        for(int i=0;i<adj.get(ele).size();i++)
        {
           
            boolean res=getTopo(adj.get(ele).get(i),st,vis,rec,adj);
            if(res)return true;
        }
        rec[ele]=false;
        st.push(ele);
        return false;
    }
}