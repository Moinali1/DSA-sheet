
// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution {
    
    class Pair{
        int d,h;
        Pair(int d,int h)
        {
            this.d=d;this.h=h;
        }
    }
    int diameter(Node root) {
        if(root==null)return 0;
        return getDia(root,1).d;
    }
    
    Pair getDia(Node node,int height)
    {
        if(node==null)return new Pair(0,0);
        
        Pair left= getDia(node.left,height+1);
        Pair right= getDia(node.right,height+1);
        
        int curH=Math.max(left.h,right.h)+1;
        int curD=Math.max(Math.max(left.d,right.d),left.h+right.h+1);
        
        return new Pair(curD,curH);
    }
}
