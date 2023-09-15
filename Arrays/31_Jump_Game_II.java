class Solution {
    public int jump(int[] nums) {
       int l=0,r=0;
       int nextR=nums[0];
       int jump=0;
       while(l<nums.length){
           if(l>r) {
                jump++;
                r=nextR;
            }
            nextR=Math.max(nextR,l+nums[l]);
            l++;
       } 
       return jump;
    }
}


//O(n*m)
// class Solution {
//     public int jump(int[] nums) {
//         int[] dp= new int[nums.length];
//         dp[nums.length-1]=0;

//         for(int i=nums.length-2;i>=0;i--)
//         {
//             int min=10000;
//             for(int j=i+1;j<=i+nums[i] && j<nums.length;j++)
//             {
//                 min=Math.min(min,dp[j]);
//             }
//             dp[i]=min+1;
//         }
//         return dp[0];
//     }
// }