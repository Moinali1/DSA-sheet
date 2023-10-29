// https://leetcode.com/problems/find-peak-element/description/
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)return 0;
        if(nums.length==2) return nums[0]>nums[1]?0:1; 
        
        int s=0,e=nums.length-1;
        while(s<e)
        {
            int mid=s+(e-s)/2;
            int left=mid==0?Integer.MIN_VALUE:nums[mid-1];
            int right=mid==nums.length-1?Integer.MIN_VALUE:nums[mid+1];
            if(nums[mid]>left && nums[mid]>right)return mid;
            else if(nums[mid]>left)s=mid+1;
            else e=mid-1;       
        }
        return s;
    }
}