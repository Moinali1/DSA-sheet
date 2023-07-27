class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean[] vis= new boolean[V];
       ArrayList<Integer> ans= new ArrayList<>();

       Queue<Integer> que= new LinkedList<>();
       que.add(0);
       
       while(!que.isEmpty())
       {
           int ele= que.remove();
          if(!vis[ele]){
               
           vis[ele]=true;
           ans.add(ele);
           for(int i=0;i<adj.get(ele).size();i++)
           {
               que.add(adj.get(ele).get(i));//condition not here because more the two node reach the same node then it will be adden in the que thatb no. of time ,that why in staring, if it repeats then also can be ignored earlier.
           }
          }
       }
       
       return ans;
    }

}// not for dis continue graph