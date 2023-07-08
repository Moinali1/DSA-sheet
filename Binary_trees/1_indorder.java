class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal= new ArrayList<>();
        return inorder(root,traversal);
    }
    public List<Integer> inorder(TreeNode node,List<Integer> traversal)
    {
        if(node==null)return traversal;
        inorder(node.left,traversal);
        traversal.add(node.val);
        inorder(node.right,traversal);
        return traversal;
    }
}