class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        if(n==1)return nums[0];
        int s=0,e=n-1;
        while(s<e)
        {
            int m=s+(e-s)/2;
            if((m%2==0 && nums[m]==nums[m+1])||(m%2==1 && nums[m]==nums[m-1]))s=m+1;
            else e=m;
        }
        return nums[e];
    }
}