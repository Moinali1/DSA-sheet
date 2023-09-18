class Solution {
    public boolean canJump(int[] nums) {
  int reach=0;
        int n=nums.length-1;
        for(int i=0;i<=reach;i++)
        {
            if(i+nums[i]>=n) return true;
            reach=Math.max(reach,i+nums[i]);
        }
        return false;
        
    }
}