//optimized
class Solution {
    int preIdx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return build(map,inorder,preorder,0,inorder.length-1);
    }
    public TreeNode build(HashMap<Integer,Integer> map,int[] in,int[] pre,int inS,int inE)
    {
        if(inS>inE)return null;

        int nodeval=pre[preIdx++];
        TreeNode node= new TreeNode(nodeval);

        node.left=build(map,in,pre,inS,map.get(nodeval)-1);
        node.right=build(map,in,pre,map.get(nodeval)+1,inE);
        return node;
    }
}




//better

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