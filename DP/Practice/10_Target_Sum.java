class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int sum=0;
       for(int i:nums)sum+=i;
       target=Math.abs(target);
       if((sum+target)%2!=0 || target>sum)return 0;

       int x=(int)(sum+target)/2; 

       int dp[][]= new int [nums.length+1][x+1];

        dp[0][0]=1;

        for(int i=1;i<=nums.length;i++)
        {
            for(int j=0;j<=x;j++)
            {
                int incl=0;
                if(j>=nums[i-1])incl=dp[i-1][j-nums[i-1]];
                int excl=dp[i-1][j];
                
                dp[i][j]=incl+excl;
            }
        }
        return  dp[nums.length][x];

    }
}