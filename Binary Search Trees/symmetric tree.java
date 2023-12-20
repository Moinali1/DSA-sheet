
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left,root.right);
    }
    public boolean isSym(TreeNode leftnode,TreeNode rightnode)
    {
        if(leftnode==null && rightnode==null)return true;
        if(leftnode==null || rightnode==null)return false;
        if(leftnode.val!=rightnode.val)return false;
        return isSym(leftnode.left,rightnode.right) && isSym(leftnode.right,rightnode.left);
    }
}