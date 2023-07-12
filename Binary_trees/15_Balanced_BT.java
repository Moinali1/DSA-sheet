// https://leetcode.com/problems/balanced-binary-tree/description/

class Solution {
    class Pair
   {
       boolean isBal; int h;
       Pair(boolean x,int y)
       {
           this.isBal=x; this.h=y;
       }
   }
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return BalCheck(root).isBal;
    }

    public Pair BalCheck(TreeNode node)
    {
        if(node==null)return new Pair(true,0);

        Pair left=BalCheck(node.left);
        Pair right=BalCheck(node.right);

        return left.isBal && right.isBal?new Pair(Math.abs(left.h-right.h)<=1,Math.max(left.h,right.h)+1)
        :new Pair(false,0);
    }
}