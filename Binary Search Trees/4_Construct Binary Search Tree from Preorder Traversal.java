// O(n) O(H)

class Solution {
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder,Integer.MAX_VALUE);
    }
    TreeNode buildTree(int[] pre,int bound)
    {
        if(i>=pre.length || pre[i]>bound)return null;
        TreeNode n= new TreeNode(pre[i++]);
        n.left= buildTree(pre,n.val);
        n.right= buildTree(pre,bound);
        return n;
    }

}






// O(nlogn) O(H)
class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
     TreeNode root= new TreeNode(preorder[0]);   
     for(int i=1;i<preorder.length;i++)
     {
         insertNode(root,preorder[i]);
     }
     return root;
    }
    TreeNode insertNode(TreeNode root,int key)
    {
        if(root==null)
        {
            TreeNode n= new TreeNode(key);
            return n;
        }
        else if(key==root.val)return root;
        else if(key<root.val)root.left=insertNode(root.left,key);
        else root.right=insertNode(root.right,key);
        return root;
    }
}