class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        int ceil=-1;
        Node itr=root;
        
        while(itr!=null)
        {
            if(itr.data<key)itr=itr.right;
            else
            {
                ceil=itr.data;
                itr=itr.left;
            }
        }
        return ceil;
    }
}