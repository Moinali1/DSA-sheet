//O(n) O(1)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small=Integer.MAX_VALUE;
        int big=Integer.MAX_VALUE;
        for(int i:nums)
        {
            if(i<=small)small=i;
            else if(i<=big)big=i;
            else return true;
        }
        return false;
    }
}


// O(n) O(n)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len=nums.length;
        int[] lmin=new int[len];
        int[] rmax=new int[len];
        lmin[0]=nums[0];rmax[len-1]=nums[len-1];
        for(int i=1;i<len;i++)
        {
            lmin[i]=Math.min(nums[i],lmin[i-1]);
            rmax[len-i-1]=Math.max(nums[len-i-1],rmax[(len-1)-i+1]);
        }

        for(int i=0;i<len;i++)
        {
            if(lmin[i]<nums[i] && nums[i]<rmax[i])return true;
        }
        return false;
    }
}