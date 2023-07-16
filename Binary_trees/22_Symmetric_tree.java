class GfG
{
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root)
    {
        if(root==null)return true;
        return isSym(root.left,root.right);
    }
     public static boolean isSym(Node leftnode,Node rightnode)
    {
        if(leftnode==null && rightnode==null)return true;
        if(leftnode==null || rightnode==null)return false;
        if(leftnode.data!=rightnode.data)return false;
        return isSym(leftnode.left,rightnode.right) && isSym(leftnode.right,rightnode.left);
    }
}