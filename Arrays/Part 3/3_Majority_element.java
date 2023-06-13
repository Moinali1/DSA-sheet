class Solution {
    public int majorityElement(int[] nums) {
        int ele=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(count==0)
            {
                count++;
                ele=nums[i];
            }
            else if(nums[i]==ele)count++;
            else count--;
        }
        return ele;
    }
}


// if(nums[i]==ele)count++;
// if(count==1)ele=nums[i];
// if(nums[i]!=ele)count--;

// https://leetcode.com/problems/majority-element/description/
