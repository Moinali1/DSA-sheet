class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        return helper(root,Key);
    }
    Node helper(Node root,int key)
    {
        if(root==null)
        {
            Node n= new Node(key);
            return n;
        }
        else if(key==root.data)return root;
        else if(key<root.data)root.left=helper(root.left,key);
        else root.right=helper(root.right,key);
        return root;
    }
}