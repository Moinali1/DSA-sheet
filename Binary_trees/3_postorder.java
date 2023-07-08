class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
         List<Integer> traversal= new ArrayList<>();
        return postorder(root,traversal);
    }
    public List<Integer> postorder(TreeNode node,List<Integer> traversal)
    {
        if(node==null)return traversal;
        postorder(node.left,traversal);
        postorder(node.right,traversal);
        traversal.add(node.val);
        return traversal;
    }
}