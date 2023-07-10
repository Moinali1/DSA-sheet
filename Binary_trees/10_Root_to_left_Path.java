// https://practice.geeksforgeeks.org/problems/root-to-leaf-paths/1

class Tree{
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        getPaths(root,new ArrayList(),ans);
        return ans;
    }
    public void getPaths(Node node,ArrayList<Integer> ongoing,ArrayList<ArrayList<Integer>> ans)
    {
        if(node==null)return;
        if(node.left==null && node.right==null)
        {
            ongoing.add(node.data);
            ans.add(new ArrayList(ongoing));
            ongoing.remove(ongoing.size()-1);
            return;
        }
        ongoing.add(node.data);
        getPaths(node.left,ongoing,ans);
        getPaths(node.right,ongoing,ans);
        ongoing.remove(ongoing.size()-1);
    }