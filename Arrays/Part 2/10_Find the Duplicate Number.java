class Solution {
    public int findDuplicate(int[] nums) {

        for(int i :nums)
        {
          int num=Math.abs(i)-1;
          if(nums[num]<0)return Math.abs(i);
          else
          {
            nums[num]=-nums[num];
          }
        }
        return -1;
    }
}

// https://leetcode.com/problems/find-the-duplicate-number/