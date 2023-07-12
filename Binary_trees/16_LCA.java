class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }
    public TreeNode lca(TreeNode node, TreeNode p, TreeNode q)
    {
        if(node==null||node==p||node==q)return node;

        TreeNode left=lca(node.left,p,q);
        TreeNode right=lca(node.right,p,q);

        return left!=null&&right!=null?node:left==null?right:left;
    }
}
