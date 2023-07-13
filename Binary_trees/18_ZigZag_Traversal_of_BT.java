
//  https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans=new ArrayList<>();
        boolean flagLR=true;
	    Queue<TreeNode> que= new LinkedList<>();
	    if(root==null)return ans;
	    
	    que.add(root);
	    
	    while(!que.isEmpty()){
	        int levelsize=que.size();
	        
            List<Integer> ongoing=new ArrayList<>();
	        for(int i=0;i<levelsize;i++)
	        {
	            if(que.peek().left!=null)que.add(que.peek().left);
	            if(que.peek().right!=null)que.add(que.peek().right);
	            
	            if(flagLR)
	            {
	                ongoing.add(que.remove().val);
	            }
	            else{
	                ongoing.add(0,que.remove().val);
	            }
	        }
            ans.add(new ArrayList(ongoing));
	        flagLR=!flagLR;
	    }
	    return ans;
    }
}


//gfg little different return a single list

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    boolean flagLR=true;
	    Queue<Node> que= new LinkedList<>();
	    ArrayList<Integer> ans= new ArrayList<>();
	    if(root==null)return ans;
	    
	    que.add(root);
	    
	    while(!que.isEmpty()){
	        int levelsize=que.size();
	        
	        for(int i=0;i<levelsize;i++)
	        {
	            if(que.peek().left!=null)que.add(que.peek().left);
	            if(que.peek().right!=null)que.add(que.peek().right);
	            
	            if(flagLR)
	            {
	                ans.add(que.remove().data);
	            }
	            else{
	                ans.add(ans.size()-i,que.remove().data);
	            }
	        }
	        flagLR=!flagLR;
	    }
	    return ans;
	}
}