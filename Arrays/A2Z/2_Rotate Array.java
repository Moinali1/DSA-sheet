class Solution {
    public void rotate(int[] nums, int k) {
        int i=0,j=nums.length-1;
        while(i<j)
        {
            int temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
        i=0;j=(k%nums.length)-1;
        while(i<j)
        {
            int temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
        i=k%nums.length;j=nums.length-1;
        while(i<j)
        {
            int temp=nums[i];
            nums[i++]=nums[j];
            nums[j--]=temp;
        }
    }
}