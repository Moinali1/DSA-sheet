class Solution {
    public boolean isValidBST(TreeNode root) {
     return checkBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    boolean checkBST(TreeNode node,long stRange,long endRange)
    {
        if(node==null)return true;
        if(node.val<=stRange || node.val>=endRange)return false;
        return checkBST(node.left,stRange,node.val) && checkBST(node.right,node.val,endRange);
    }
}