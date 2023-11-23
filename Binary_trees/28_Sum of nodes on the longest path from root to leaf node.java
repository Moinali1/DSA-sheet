class Solution{
    int ans=0,ht=1;
    public int sumOfLongRootToLeafPath(Node root)
    {
      ans=root.data;    
      helper(root,0,1);    
      return ans;
    }
    public void helper(Node root,int sum,int h)
    {
        if(root==null)return;
        sum+=root.data;
        if(h==ht && sum>ans)
        {
            ans=sum;
        }
        if(h>ht) 
        {
            ans=sum;
            ht=h;
        }
        helper(root.left,sum,h+1);
        helper(root.right,sum,h+1);
    }
    
}