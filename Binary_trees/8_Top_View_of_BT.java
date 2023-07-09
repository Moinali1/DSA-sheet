// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Pair{
        int hlevel;
        Node node;
        Pair(int level,Node n)
        {
            this.hlevel=level;
            this.node=n;
        }
    }
    
    static ArrayList<Integer> topView(Node root)
    {
    ArrayList<Integer> ans= new ArrayList<>();    
    TreeMap<Integer,Pair> map= new TreeMap<>();
    getTopView(root,0,0,map);
    for(Pair p:map.values())ans.add(p.node.data);
    return ans;
    }
    
    public static void getTopView(Node node,int curlevel,int hlevel,TreeMap<Integer,Pair> map)
    {
        if(node==null)return;
        if(!map.containsKey(curlevel))map.put(curlevel,new Pair(hlevel,node));
        else if(map.containsKey(curlevel) && map.get(curlevel).hlevel>hlevel)
            map.put(curlevel,new Pair(hlevel,node));
        getTopView(node.left,curlevel-1,hlevel+1,map);
        getTopView(node.right,curlevel+1,hlevel+1,map);
    }
}
