// https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
      return getHeight(node,1);
    }
    int getHeight(Node node,int height)
    {
        if(node==null)return height-1;
        
        int leftH=getHeight(node.left,height+1);
        int rightH=getHeight(node.right,height+1);
        
        return Math.max(leftH,rightH);
    }
}