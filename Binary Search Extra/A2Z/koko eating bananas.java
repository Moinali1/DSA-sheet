//similar to aggresive cow
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int s=1,e=0;
       for(int i:piles) e=Math.max(e,i); 

       while(s<e)
       {
           int mid=s+(e-s)/2;
           int hrs=0;
           for(int i:piles)
           {
               int cur=(int)Math.ceil((double)i/mid);
               hrs+=cur;
           }
           if(hrs>h)
               s=mid+1;
           else
               e=mid;  
       }
       return s;
    }
}

// koko eating bananas