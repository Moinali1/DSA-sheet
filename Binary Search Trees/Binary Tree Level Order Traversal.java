class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList();
        if(root==null)return ans;
        Queue<TreeNode> que= new LinkedList();

        que.add(root);
        while(!que.isEmpty())
        {
            int levelSize=que.size();
            List<Integer> ongoing= new ArrayList();
            for(int i=0;i<levelSize;i++)
            {
                if(que.peek().left!=null)que.add(que.peek().left);
                if(que.peek().right!=null)que.add(que.peek().right);
                ongoing.add(que.remove().val);
            }
            ans.add(new ArrayList(ongoing));
        }

        return ans;
    }
}





