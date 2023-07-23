//leetcode

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> nextSt=new Stack<>();
        Stack<TreeNode> beforeSt=new Stack<>();
        TreeNode nxt=root,bfr=root;
        while(nxt!=null){
            nextSt.push(nxt);
            nxt=nxt.left;
        }
        while(bfr!=null){
            beforeSt.push(bfr);
            bfr=bfr.right;
        }

        TreeNode i=next(nextSt),j=before(beforeSt);

        while(i.val<j.val)
        {
            int sum=i.val+j.val;
            if(sum==k)return true;
            else if(sum<k)i=next(nextSt);
            else j=before(beforeSt);
        }

        return false;
    }
    public TreeNode next(Stack<TreeNode> nextSt)
    {
        TreeNode ele=nextSt.pop();
        if(ele.right!=null){
        TreeNode cur=ele.right;
            while(cur!=null)
            {
                nextSt.push(cur);
                cur=cur.left;
            }
        }
        return ele;
    }
    public TreeNode before(Stack<TreeNode> beforeSt)
    {
        TreeNode ele=beforeSt.pop();
        if(ele.left!=null){
        TreeNode cur=ele.left;
            while(cur!=null)
            {
                beforeSt.push(cur);
                cur=cur.right;
            }
        }
        return ele;
    }
}