class Solution {
    public boolean check(int[] nums) {
        int i=1;
        while(i<nums.length && nums[i-1]<=nums[i])i++;
        if(i++==nums.length)return true;

        if(nums[0]<nums[nums.length-1])return false;        
        
        while(i<nums.length)
            if(nums[i-1]>nums[i++])return false;
        
        return true;
    }
}

    // public boolean check(int[] A) {
        // int k = 0, n = A.length;
        // for (int i = 0; i < n; ++i) {
        //     if (A[i] > A[(i + 1) % n]) {
        //         k++;
        //     }
        //     if (k > 1) {
        //         return false;
        //     }
        // }
        // return true;
    // }