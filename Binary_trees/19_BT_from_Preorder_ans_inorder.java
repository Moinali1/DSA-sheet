/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int preIdx=0;
    public TreeNode buildTree(int[] pre, int[] in) {
        TreeNode root=build(pre,in,0,in.length-1);
        return root;
    }
    public TreeNode build(int[] pre, int[] in,int inS,int inE)
    {
        if(inS>inE)return null;

        int ele=pre[preIdx++];
        TreeNode root=new TreeNode(ele);
        int pos=findpos(in,ele);

        root.left=build(pre,in,inS,pos-1);
        root.right=build(pre,in,pos+1,inE);

        return root;
    }

    public int findpos(int in[],int ele)
    {
        for(int i=0;i<in.length;i++)
        {
            if(in[i]==ele)return i;
        }
        return -1;
    }
}