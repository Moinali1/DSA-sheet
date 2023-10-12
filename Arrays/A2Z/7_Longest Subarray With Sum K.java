public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        int i=0,j=-1,ans=0;
        long sum=0;

        while(j<a.length)
        {
            while(i<j && sum>k)
            {
                sum-=a[i];
                i++;
            }

           
            if(sum==k)ans=Math.max(ans,j-i+1);
            j++;
            if(j<a.length)sum+=a[j];
        
            
        }
        return ans;
        
    }
}

// https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
