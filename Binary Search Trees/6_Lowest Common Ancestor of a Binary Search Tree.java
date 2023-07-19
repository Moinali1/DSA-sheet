//optimized
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        while(root!=null)
        {
        if(p.val>root.val && q.val>root.val)root=root.right;
        else if(p.val<root.val && q.val<root.val)root=root.left;
        else return root;
        }
        return null;
    }
}


//better
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(root.val==p.val || root.val==q.val )return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null && right==null)return null;
        return left!=null && right!=null?root:left!=null?left:right;
    }
}