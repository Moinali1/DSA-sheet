
class Solution {
    int preIdx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return build(map,inorder,preorder,0,inorder.length-1);
    }
    public TreeNode build(HashMap<Integer,Integer> map,int[] in,int[] pre,int inS,int inE)
    {
        if(inS>inE)return null;

        int nodeval=pre[preIdx++];
        TreeNode node= new TreeNode(nodeval);

        node.left=build(map,in,pre,inS,map.get(nodeval)-1);
        node.right=build(map,in,pre,map.get(nodeval)+1,inE);
        return node;
    }
}