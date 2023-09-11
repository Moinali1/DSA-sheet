class Solution {
    public int reverse(int x) {
      boolean positive=x>=0;
      x=Math.abs(x);
      int ans=0;
      while(x>0)
      {
          if(ans==Integer.MAX_VALUE/10 && x%10>7)return 0;
          else if(ans>Integer.MAX_VALUE/10)return 0;
          ans*=10;
          ans+=x%10;
          x/=10;
      }  
      return positive?ans:-ans;
    }
}