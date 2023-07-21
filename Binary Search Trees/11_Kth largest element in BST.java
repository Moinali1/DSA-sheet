class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        int result[]={K,0};
        findNode(root,result);
        return result[1];
    }
    public void findNode(Node root,int[] res)
    {
        if(root==null || res[0]==0)return;
        findNode(root.right,res);
        if(--res[0]==0){res[1]=root.data;return;}
        findNode(root.left,res);
    }
}