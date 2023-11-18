
class Solution {
    public static int maxFrequency(int[] nums, int n, int k) {
       Arrays.sort(nums);
       int l=0,r=0,res=0;
       long total=0;

       for(r=0;r<nums.length;r++)
       {
           total+=nums[r];
           while(nums[r]*(r-l+1)>total+k)
           {
               total-=nums[l];
               l++;
           }
           res=Math.max(res,r-l+1);
       } 
       return res;
    }
}
