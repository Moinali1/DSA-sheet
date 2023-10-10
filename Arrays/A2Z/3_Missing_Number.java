class Solution {
    public int missingNumber(int[] nums) {
        
        for(int i=0;i<nums.length;)
        {
            if(nums[i]<nums.length && nums[i]!=nums[nums[i]])
            {
                swap(nums,i,nums[i]);
            }
            else i++;    
        }

        for(int i=0;i<nums.length;i++)
            {
                if(nums[i]!=i)return i;
            }

        return nums.length;    
    }
    void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}