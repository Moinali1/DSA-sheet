class Solution {
    public int maxArea(int[] h) {
      int s=0,e=h.length-1,ans=0;  
    while(s<e)
    {
        if(h[s]<=h[e])
        {
            ans=Math.max(ans,Math.min(h[s],h[e])*(e-s));
            s++;
        }
        else
        {
           ans=Math.max(ans,Math.min(h[s],h[e])*(e-s));
           e--; 
        }
    }
    return ans;
    }
}