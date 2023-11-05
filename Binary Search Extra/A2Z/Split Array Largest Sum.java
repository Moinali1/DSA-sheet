class Solution {
    public int splitArray(int[] nums, int m) {
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++)
        {
        start=Math.max(start,nums[i]);
        end=end+nums[i];
        } 
        while(start<end)
        {
            int mid=start+(end-start)/2;
            int sum=0;
            int chunk=1;
            for(int i=0;i<nums.length;i++)
            {
                if(sum +nums[i]> mid)
                {
                    sum=nums[i];
                    chunk++;
                }
                else{
                    sum=sum+nums[i];
                }
            }
        
        if(chunk>m)
        {
            start=mid+1;
        }
        else
        {
            end=mid;
        }
        }
     return end;
      }
  
}