
class Solution
{
    static class DetailNode{
        int vl,hl;
        Node node;
        DetailNode(int vl,int hl,Node node)
        {
            this.hl=hl;this.vl=vl;
            this.node=node;
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> map= new TreeMap<>();
        Queue<DetailNode> que= new LinkedList<>();
        
        que.add(new DetailNode(0,0,root));
        
        while(!que.isEmpty())
        {
            DetailNode dn=que.remove();
            
            Node node=dn.node;
            int vl=dn.vl;
            int hl=dn.hl;
            
            if(!map.containsKey(vl))
            {
                map.put(vl,new TreeMap<>());
                map.get(vl).put(hl,new ArrayList(Arrays.asList(node.data)));
            }
            else{
                if(!map.get(vl).containsKey(hl))
                {
                    map.get(vl).put(hl,new ArrayList(Arrays.asList(node.data)));
                }
                else{
                    map.get(vl).get(hl).add(node.data);
                }
            }
            
            if(node.left!=null)
            {
                que.add(new DetailNode(vl-1,hl+1,node.left));}
            if(node.right!=null)
                {que.add(new DetailNode(vl+1,hl+1,node.right));}
            
    
        }
        
        ArrayList<Integer> ans= new ArrayList<>();
        
        for(Map.Entry<Integer,TreeMap<Integer,ArrayList<Integer>>> entry : map.entrySet())
        {
            for(Map.Entry<Integer,ArrayList<Integer>> innerEntry : entry.getValue().entrySet())
            {
                for(int i: innerEntry.getValue())
                {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}