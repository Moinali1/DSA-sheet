
class Solution {
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k) {
        Node cur= root;
        
        while(cur!=null)
        {
            if(cur.left==null)
            {
                k--;
                if(k==0)return cur.data;
                cur=cur.right;
            }
            else{
                Node pred=cur.left;
                while(pred.right!=null && pred.right!=cur)pred=pred.right;
                if(pred.right==null)
                {
                    pred.right=cur;
                    cur=cur.left;
                }
                else
                {
                    k--;
                    if(k==0)return cur.data;
                    pred.right=null;
                    cur=cur.right;
                }
            }
        }
        return -1;
    }
}