class Solution {
    public Node connect(Node root) {
        if(root==null)return null;
        Queue<Node> que= new LinkedList<>();
        que.add(root);
        que.add(null);

        while(!que.isEmpty())
        {
            Node node= que.remove();
            if(node==null)
            {
                if(!que.isEmpty())que.add(null);
            }
            else{
                node.next=que.peek();
                if(node.left!=null)que.add(node.left);
                if(node.right!=null)que.add(node.right);
            }
        }
        return root;
    }
}