https://leetcode.com/problems/maximum-product-subarray/description/

class Solution {
    public int maxProduct(int[] nums) {
        int maxpro=nums[0];
        int minpro=nums[0];
        int ans=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp=maxpro;
                maxpro=minpro;
                minpro=temp;

            }
            maxpro=Math.max(maxpro*nums[i],nums[i]);
            minpro=Math.min(minpro*nums[i],nums[i]);  
            ans=Math.max(ans,maxpro);
        }
        return ans;
    }
}

// https://leetcode.com/problems/maximum-product-subarray/solutions/2781113/kadane-s-algo-for-maximum-product-subarray/