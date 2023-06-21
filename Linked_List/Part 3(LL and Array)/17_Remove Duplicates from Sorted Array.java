// app1
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int n:nums)
        {
            if(i==0 || n>nums[i-1])
            {
                nums[i++]=n;
            }
        }
        return i;
    }
}


// app2
class Solutio {
    public int removeDuplicates(int[] nums) {
        int ele=nums[0],idx=1;
        for(int j=1;j<nums.length;j++)
        {
            if(nums[j]!=ele)
            {
                nums[idx]=nums[j];
                ele=nums[j];
                idx++;
            }
        }
        return idx;
    }
}