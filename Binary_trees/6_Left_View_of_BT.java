class Tree
{
    
     ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> leftview= new ArrayList<>();
        if(root==null)return leftview;
        Queue<Node> que= new LinkedList<>();
        que.add(root);
        que.add(null);
        leftview.add(root.data);
        
        while(!que.isEmpty())
        {
            Node cur=que.remove();
            if(cur==null){
                if(!que.isEmpty()){
                    que.add(null);
                    leftview.add(que.peek().data);
                }
                continue;
            }
            if(cur.left!=null)que.add(cur.left);
            if(cur.right!=null)que.add(cur.right);
        }
        return leftview;
    }
}


// class Tree
// {
//     //Function to return list containing elements of left view of binary tree.
//     ArrayList<Integer> leftView(Node root)
//     {
//         ArrayList<Integer> leftview= new ArrayList<>();
//         Queue<Node> que= new LinkedList]<>();
//         que.add(root);
//         que.add(null);
//         boolean flag=true;
        
//         while(!que.isEmpty())
//         {
//             Node cur=que.remove();
//             if(cur==null){
//                 flag=true;
//                 if(!que.isEmpty())que.add(null);
//                 continue;
//             }
//             if(flag){
//                 leftview.add(cur.data);
//                 flag=false;
//             }
//             if(cur.left!=null)que.add(cur.left);
//             if(cur.right!=null)que.add(cur.right);
//         }
//         return leftview;
//     }
// }



// https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1