// revision done
//Binary Search
class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            if(ans.get(ans.size()-1)<nums[i])ans.add(nums[i]);
            else{
                int s=0,e=ans.size()-1;
                while(s<=e)
                {
                    int mid=(s+e)/2;
                    if(ans.get(mid)<nums[i])s=mid+1;
                    else e=mid-1;
                }
                ans.set(s,nums[i]);
            }
        }
        return ans.size();
    }
}




//Bottom up Not working
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n= nums.length;
//         int dp[][]= new int[n+1][n+1];

//         for(int i=1;i<=n;i++)

//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=n;j++)
//             {
//                 int incl=0;
//                 if(nums[j-1]>nums[i-1])
//                 {
//                     incl=1+dp[i-1][i];
//                 } 
//                 int excl=dp[i-1][j];
//                 dp[i][j]=Math.max(incl,excl);      
//             }
//         }

//         return dp[n][n];
//     }
// }


// Top Down DP N*M solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]= new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)dp[i][j]=-1;
        }
        return lis(n,-1,nums,dp,n);
       
    }
    int lis(int cur,int preIncl,int[] nums,int[][] dp,int n)
    {
        if(cur==0)return 0;

        if(preIncl!=-1 && dp[cur][preIncl]!=-1)return dp[cur][preIncl];

        int incl=0;
        if(preIncl==-1 || nums[preIncl-1]>nums[cur-1]){
            incl=1+lis(cur-1,cur,nums,dp,n);
        }
        int excl=lis(cur-1,preIncl,nums,dp,n);

        if(preIncl!=-1)dp[cur][preIncl]=Math.max(incl,excl);
        return Math.max(incl,excl);
    }
}