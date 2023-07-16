class Solution {
    int ans=-1001;
    public int maxPathSum(TreeNode root) {
        getPathSum(root);
        return ans;
    }
    public int getPathSum(TreeNode node)
    {
        if(node==null)return 0;
        int left=Math.max(getPathSum(node.left),0);
        int right=Math.max(getPathSum(node.right),0);
        ans=Math.max(ans,left+right+node.val);
        return Math.max(left+node.val,right+node.val); 
    }
}