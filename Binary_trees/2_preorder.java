class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal= new ArrayList<>();
        return preorder(root,traversal);
    }
    public List<Integer> preorder(TreeNode node,List<Integer> traversal)
    {
        if(node==null)return traversal;
        traversal.add(node.val);
        preorder(node.left,traversal);
        preorder(node.right,traversal);
        return traversal;
    }
}