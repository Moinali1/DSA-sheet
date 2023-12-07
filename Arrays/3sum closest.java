
class Solution
{
    static int closest3Sum(int nums[], int N, int target)
    {
        Arrays.sort(nums);
        int i=0;
        
        int curdiff=Integer.MAX_VALUE;
        int ans=0;
        for(i=0;i<nums.length-2;i++)
        {  
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {   
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target)
                    return sum;
                else if(sum<target)
                {
                    j++;
                }
                else if(sum>target)
                {
                    
                    k--;
                }
                int diff=Math.abs(target-sum);
                if(diff<curdiff)
                {curdiff=diff;
                 ans=sum;
                }
            }
        }
        return ans;
    }
}