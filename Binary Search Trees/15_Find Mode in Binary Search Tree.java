// Using Morris Traversal
class Solution {
    TreeNode pre=null;
    int maxnodes=0,curcount=0;
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> ans= new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null)
        {
            if(cur.left==null)
            {
                compare(ans,cur);
                cur=cur.right;
            }   
            else
            {
                TreeNode succ=cur.left;
                while(succ.right!=null && succ.right!=cur)
                {
                    succ=succ.right;
                }
                
                if(succ.right==null){
                    succ.right=cur;
                    cur=cur.left;
                }
                else
                {
                    compare(ans,cur);
                    succ.right=null;
                    cur=cur.right;
                }
            }
        }
        int idx=0; int[] arr= new int[ans.size()];
        for(int i:ans)
            arr[idx++]=i;
        return arr;
    }
    void compare(ArrayList<Integer> ans,TreeNode curNode)
    {   
        if(pre!=null && pre.val==curNode.val)curcount++;
        else{
            curcount=1;
            pre=curNode;
        }
        if(curcount>maxnodes)
        {
            maxnodes=curcount;
            ans.clear();
            ans.add(curNode.val);
        }
        else if(curcount==maxnodes){
            ans.add(curNode.val);
        }
    }
}