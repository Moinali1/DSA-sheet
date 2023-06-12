class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1,j=nums.length-2;
        
        while(j!=-1 && nums[j]>=nums[j+1])j--;
        if(j==-1)
        {
            reverse(nums,0,nums.length-1);
            return;
        }
        while(nums[i]<=nums[j])
        {
            i--;
        }
        swap(nums,j,i);
        reverse(nums,j+1,nums.length-1);
    }
    public void reverse(int[] nums,int s,int e)
    {
        while(s<e)
        {
            int temp= nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;e--;
        }
    }
    public void swap(int []nums,int s,int e)
    {
            int temp= nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
    }
}