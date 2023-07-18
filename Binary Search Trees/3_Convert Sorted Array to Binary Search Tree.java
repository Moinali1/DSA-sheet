// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);
    }
    TreeNode makeTree(int[] nums,int s,int e)
    {
        if(s>e)return null;
        int mid=s+(e-s)/2;
        int value=nums[mid];
        TreeNode node= new TreeNode(value);
        node.left=makeTree(nums,s,mid-1);
        node.right=makeTree(nums,mid+1,e);

        return node;
    }
}