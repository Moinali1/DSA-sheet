class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=m+n-1;
        int i=m-1,j=n-1;

        while(j>=0)
        {
            if(i>=0 && nums1[i]>nums2[j])
                nums1[p--]=nums1[i--];
            else 
                nums1[p--]=nums2[j--];
        }
    }
}

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int p=m+n-1;
//         int i=m-1,j=n-1;

//         while(p>=0 && i>=0 && j>=0)
//         {
//             if(nums1[i]>nums2[j]){
//                 nums1[p]=nums1[i];
//                 nums1[i]=0;
//                 i--;
//                 }
//             else if(j>=0)
//             {
//                 nums1[p]=nums2[j];
//                 j--;
//             }  
//             p--;  
//         }
//         while(j>=0){
//             nums1[p]=nums2[j];
//             j--;p--;
//         }
//     }
// }


// https://leetcode.com/problems/merge-sorted-array/description/