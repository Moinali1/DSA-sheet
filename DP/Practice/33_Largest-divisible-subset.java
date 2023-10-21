class Solution {
  
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int dp[]= new int[nums.length];
        dp[0]=1;
        int maxIdx=0,maxOfDp=0;

        for(int i=1;i<nums.length;i++)
        {
            int maxOfPre=0;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0)
                {
                    maxOfPre=Math.max(maxOfPre,dp[j]);
                }
            }
            dp[i]=1+maxOfPre;
            if(dp[i]>maxOfDp)
            {
                maxOfDp=dp[i];
                maxIdx=i;
            }
        }
        List<Integer> ans= new ArrayList<>();
        ans.add(nums[maxIdx]);
            for(int j=maxIdx-1;j>=0;j--)
            {
                if(dp[j]==dp[maxIdx]-1 && nums[maxIdx]%nums[j]==0)
                {
                    ans.add(nums[j]);
                    maxIdx=j;
                }
            }
    
        return ans;
    }
   
}


//TLE 
// class Solution {
//     List<Integer> ans= new ArrayList<>();
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         int size=nums.length;
//         lis(-1,0,nums,dp,new ArrayList<>());
//         return ans;
//     }
//    void lis(int pre,int cur,int arr[],int dp[][],List<Integer> ongoing)
//     {
//         if(ongoing.size()>ans.size())
//         {
//             ans=new ArrayList(ongoing);
//         }
//         if(cur==arr.length) return;
        
//         if(pre==-1 || arr[cur]%arr[pre]==0 || arr[pre]%arr[cur]==0){
//             ongoing.add(arr[cur]);
//             lis(cur,cur+1,arr,dp,ongoing);
//             ongoing.remove(ongoing.size()-1);
//         }
//         lis(pre,cur+1,arr,dp,ongoing);
//     }
// }
        