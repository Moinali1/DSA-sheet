class BSTIterator {
    Stack<TreeNode> st= new Stack<>(); 
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        cur=root;
        while(cur!=null)
        {
            st.add(cur);
            cur=cur.left;
        }
    }
    
    public int next() {
        TreeNode ele=st.pop();
        if(ele.right!=null){
             cur=ele.right;
             while(cur!=null){
                st.add(cur);
                cur=cur.left;
             }
         }
        return ele.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}