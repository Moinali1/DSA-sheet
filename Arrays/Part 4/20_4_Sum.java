import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> ans= new ArrayList<>();
        if(n<4)return ans;
        int i=0,j=i+1,k=j+1,l=n-1;
        Arrays.sort(nums);
        while(i<=n-4)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                    i++;continue;
            }
            j=i+1;
            while(j<=n-3)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                {
                    j++;continue;
                }
                k=j+1;l=n-1;
                while(k<l)
                {
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
                    if(sum==target) 
                        {
                        ans.add(new ArrayList(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
                        while(k<l && nums[k]==nums[k+1])k++;
                        while(k<l && nums[l]==nums[l-1])l--;
                        k++;l--;
                        }
                    else if(sum>target)
                    {
                        l--;
                    }
                    else k++;    
                }
                j++;
            }
            i++;
        }
        return ans;
    }
} 

// https://leetcode.com/problems/4sum/description/