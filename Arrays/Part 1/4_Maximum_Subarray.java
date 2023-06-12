class Solution {
    public int maxSubArray(int[] nums) {
       int sum=Integer.MIN_VALUE,cur=0;
       for(int i:nums)
       {
           cur+=i;
           sum=Math.max(sum,cur);
           if(cur<0)cur=0;
       } 
       return sum;
    }
}