class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        int s=0,e=nums.length-1;
        int ans[]= {-1,-1};
        int idx=-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(nums[mid]<target)s=mid+1;
            else if(nums[mid]>target)
            {
                e=mid-1;
            }
            else{
                idx=mid;
                e--;
            }     
        }
        if(idx!=-1 && nums[idx]==target)ans[0]=idx;
        s=0;e=nums.length-1;idx=-1;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(nums[mid]<target)
            {
                s=mid+1;
            }
            else if(nums[mid]>target)e=mid-1;
            else 
            {
                idx=mid;
                s++;
            }
        }
        if(idx!=-1 && target==nums[idx])ans[1]=idx;
        return ans;
    }
}