class Solution {
    public void sortColors(int[] nums) {
        int s=0,e=nums.length-1,i=0;
        while(i<nums.length)
        {
            if(nums[i]==0)
            {
                swap(nums,i,s);
                s++;i++;
            }
            else if(nums[i]==2)
            {
                if(i>=e)break;
                swap(nums,i,e);
                e--;
            }
            else i++;
        }
    }
    public void swap(int[] nums,int s,int e)
    {
        int temp=nums[s];
        nums[s]=nums[e];
        nums[e]=temp;
    }
}



// class Solution {
//     public void sortColors(int[] nums) {
//         int i=0,j=nums.length-1;
//         while(i<j)
//         {
//             if(nums[i]==2)
//             {
//                 swap(nums,i,j);
//                 j--;
//             }
//             else i++;
//         }
//         i=0;j=nums.length-1;
//         while(i<j)
//         {
//             if(nums[j]==0)
//             {
//                 swap(nums,i,j);
//                 i++;
//             }
//             else j--;
//         }
//     }
//     public void swap(int[] nums,int i,int j)
//     {
//         int temp=nums[i];
//         nums[i]=nums[j];
//         nums[j]=temp;
//     }
// }


// class Solution {
//     public void sortColors(int[] nums) {
//         int s=0,e=nums.length-1,i=0;
//         while(i<nums.length)
//         {
//             if(nums[i]==0)
//             {
//                 swap(nums,i,s);
//                 s++;i++;
//             }
//             else if(nums[i]==2)
//             {
//                 if(i>=e)break;
//                 swap(nums,i,e);
//                 e--;
//             }
//             else i++;
//         }
//     }
//     public void swap(int[] nums,int s,int e)
//     {
//         int temp=nums[s];
//         nums[s]=nums[e];
//         nums[e]=temp;
//     }
// }