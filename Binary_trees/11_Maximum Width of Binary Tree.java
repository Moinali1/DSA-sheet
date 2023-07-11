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
    class Pair{
        int idx;
        TreeNode node;
        Pair(TreeNode node,int idx)
        {
            this.idx=idx;
            this.node=node;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       Queue<Pair> que= new LinkedList<>();
       que.add(new Pair(root,1));
       que.add(null);
       int ans=0,stIdx=1;

        while(!que.isEmpty())
        {
            Pair p= que.remove();
            if(!que.isEmpty() && que.peek()==null)
            {
                ans=Math.max(ans,p.idx-stIdx+1);
            }
            if(p==null && !que.isEmpty())
            {
                stIdx=que.peek().idx;
                que.offer(null);
                continue;
            }
            if(p!=null && p.node.left!=null)que.add(new Pair(p.node.left,(p.idx*2)));
            if(p!=null && p.node.right!=null)que.add(new Pair(p.node.right,(p.idx*2)+1));
        }

        return ans;
    }
}












