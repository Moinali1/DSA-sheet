// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


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


//for leetcode hard

class Solution {
    class Pairs
    {
        TreeNode n;
        int v;
        int h;
        Pairs(TreeNode n,int v,int h)
        {
            this.n=n;
            this.v=v;
            this.h=h;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Pairs> q=new LinkedList<>();
        q.add(new Pairs(root,0,0));
        while(!q.isEmpty())
        {
            Pairs p=q.remove();
            TreeNode node=p.n;
            int vl=p.v;
            int hl=p.h;

            if(!map.containsKey(vl))
            {
                map.put(vl,new TreeMap<>());
            }
            if(!map.get(vl).containsKey(hl))
            {
                map.get(vl).put(hl,new PriorityQueue<>());
            }
            map.get(vl).get(hl).add(node.val);

            if(node.left!=null)
            {
                q.add(new Pairs(node.left,vl-1,hl+1));
            }
            if(node.right!=null)
            {
                q.add(new Pairs(node.right,vl+1,hl+1));
            }
        }

        for(TreeMap<Integer,PriorityQueue<Integer>> mf : map.values())
        {
            List<Integer> list=new ArrayList<>();
            for(PriorityQueue<Integer> pq : mf.values())
            {
                while(!pq.isEmpty())
                {
                    list.add(pq.remove());
                }
            }
            ans.add(list);
        }
        return ans;
    }
}