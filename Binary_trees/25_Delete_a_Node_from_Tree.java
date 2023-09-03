
class Solution {
    public TreeNode deleteNode(TreeNode root, int val) {
    if(root==null)return null;
    if(root.val>val)
    {
        root.left=deleteNode(root.left,val);
    }
    else if(root.val<val)
    {
        root.right=deleteNode(root.right,val);
    } 
    else
    {
        //case 1
        if(root.left==null && root.right==null) return null;
        //case 2
        if(root.left==null) return root.right;
        if(root.right==null) return root.left;
        //case 3
        TreeNode leftcorner=findSuccessor(root.right,val);
        root.val=leftcorner.val;
        root.right=deleteNode(root.right,leftcorner.val);
    }
    return root;
    }
    public TreeNode findSuccessor(TreeNode node,int val)
{
    while(node.left!=null)
    {
        node=node.left;
    }
    return node;
}
}

// https://leetcode.com/problems/delete-node-in-a-bst/description/