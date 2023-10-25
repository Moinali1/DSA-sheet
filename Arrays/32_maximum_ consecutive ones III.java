class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int ans=0;

        while(i<nums.length && j<nums.length)
        {
            while(k>=0 && j<nums.length)
            {
                if(nums[j]==0 && k==0)break;
                if(nums[j]==0)k--;
                j++;
            }
            ans=Math.max(ans,j-i);

            while(i<nums.length && k==0)
            {
                if(nums[i]==0)k++;
                i++;
            }
        }
        return ans;
    }
}

// more better
public int longestOnes(int[] A, int K) {
        int zeroCount=0,start=0,res=0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0) zeroCount++;
            while(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }