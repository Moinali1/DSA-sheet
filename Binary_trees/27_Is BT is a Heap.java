

// User Function template for JAVA

/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int countnodes(Node root)
    {
        if(root==null)return 0;
        int l=countnodes(root.left);
        int r=countnodes(root.right);
        
        return l+r+1;
    }
    boolean isHeap(Node tree) {
      int size= countnodes(tree);
      if(isCBT(tree,0,size-1) && heapppt(tree))
      {
          return true;
      }
      return false;
    }
    boolean isCBT(Node tree,int i,int size)
    {
        if(tree==null)return true;
        if(i>size)return false;
        
        return isCBT(tree.left,i*2+1,size) && isCBT(tree.right,i*2+2,size);
    }
    boolean heapppt(Node root)
    {
        if(root==null)return true;
        if(root.left !=null && root.left.data>root.data)return false;
        if(root.right !=null && root.right.data>root.data)return false;
        
        return heapppt(root.left) && heapppt(root.right);
    }
}











// class Solution {
//     class Pair
//     {
//         int val;int h;boolean validHp;
//         Pair(int val,int h,boolean validHp)
//         {
//             this.val=val;
//             this.h=h;
//             this.validHp=validHp;
//         }
//     }
    
//     boolean isHeap(Node tree) {
//      return helper(tree).validHp;
//     }
//     Pair helper(Node tree)
//     {
//         if(tree==null)return new Pair(0,0,true);
        
//         Pair l=helper(tree.left);
//         Pair r=helper(tree.right);
        
//         if(l.h-r.h>1 || l.h<r.h  || l.val>tree.data || r.val>tree.data || l.validHp==false || r.validHp==false)
//         {
//         return new Pair(tree.data,Math.max(l.h,r.h),false);
//         }
//         else
//         {
//             return new Pair(tree.data,l.h+1,true);
//         }
//     }
// }