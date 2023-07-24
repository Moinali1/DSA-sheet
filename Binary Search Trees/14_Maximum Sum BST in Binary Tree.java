
class Solution {
    class Info{
        int small,large,sum;
        Info(int sum,int s,int l){
            this.sum=sum;
            this.small=s;
            this.large=l;
        }
    }
    int ans=Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        getMaxSum(root);
        return ans<0?0:ans;
    }
    public Info getMaxSum(TreeNode node)
    {
        if(node==null)return new Info(0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        if(node.left==null && node.right==null)return new Info(node.val,node.val,node.val);

        Info left=getMaxSum(node.left);
        Info right=getMaxSum(node.right);
        if(left.large<node.val && right.small>node.val)
        {
            int cur1=left.sum+right.sum+node.val;
            int cur2=node.left!=null&&node.right!=null?Math.max(left.sum,right.sum):node.left==null?right.sum:left.sum;
            ans=Math.max(ans,Math.max(cur1,cur2));
            // int sum=Math.max(cur1,cur2);
            int small=Math.min(node.val,left.small);
            int large=Math.max(node.val,right.large);
            return new Info(cur1,small,large);
        }
        else{
        int sum=Math.max(left.sum,right.sum);
        ans=Math.max(ans,sum);
        return new Info(sum,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
    }
}


// [-4,-2,-5]
// [8,6,1,9,null,-5,4,null,null,null,-3,null,10]
// [9,2,3,null,2,null,null,3,null,-5,4,null,1,null,10]
// [6,4,12,2,6,10,14,1,3,5,7,9,11,13,15]
