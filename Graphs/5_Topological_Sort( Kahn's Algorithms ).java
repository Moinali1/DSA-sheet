class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        Queue<Integer> que = new LinkedList<>();
        int[] inDegree=new int[V];
        int[] ans=new int[V];

        
        int j=0,k=0;
        for(ArrayList<Integer> i:adj) 
        {
            for(int ele:i)
                inDegree[ele]++;
        }
        
        for(int i=0;i<V;i++)
            if(inDegree[i]==0)que.add(i);
        
        while(!que.isEmpty())
        {
            int ele=que.remove();
            ans[k++]=ele;
        
            for(int i=0;i<adj.get(ele).size();i++)
            {
                int child=adj.get(ele).get(i);
                inDegree[child]--;
                if(inDegree[child]==0)que.add(child);
            }
        }
        return ans;
    }

}
