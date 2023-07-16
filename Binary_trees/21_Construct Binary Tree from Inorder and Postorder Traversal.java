class Solution {
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         HashMap<Integer,Integer> map= new HashMap<>();
         this.postIdx=postorder.length-1;
         for(int i=0;i<inorder.length;i++)map.put(inorder[i],i);
         return build(inorder,postorder,0,postorder.length-1,map);
    }
    public TreeNode build(int[] in, int[] post,int inS,int inE,HashMap<Integer,Integer> map)
    {
        if(inS>inE)return null;
        int idx=postIdx--;
        TreeNode node= new TreeNode(post[idx]);
        node.right= build(in,post,map.get(post[idx])+1,inE,map);
        node.left= build(in,post,inS,map.get(post[idx])-1,map);
        return node;
    }
}