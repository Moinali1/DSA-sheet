class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
       int s=1,e=0;
       for(int num:nums)e=Math.max(num,e); 

       while(s<e)
       {
            int mid=s+(e-s)/2;
            int sum=0;
            for(int num:nums)
            {
                sum+=(int)Math.ceil((double)num/mid);
            }
    
            if(sum>threshold)
            {
                 s=mid+1;
            }
            else e=mid;
       }
       return s;
    }
}