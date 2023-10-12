class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans= new ArrayList<>();    
    int len=nums.length;
    Arrays.sort(nums);
    int i,j,k,sum;
    for(i=0;i<=len-3;i++)
    {
        if(i>0 && nums[i]==nums[i-1])continue;
        j=i+1;k=len-1;
        while(j<k)
        {
            sum=nums[i]+nums[j]+nums[k];
            if(sum==0) 
            {
                ans.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k])));
                while(j<k && nums[j]==nums[j-1])j++;
                while(j<k && nums[k]==nums[k-1])k--;
                j++;k--;
            }
            else if(sum>0)k--;
            else j++;
        }
    }
    return ans;
    }
}