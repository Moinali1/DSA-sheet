import java.util.*;
class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        int sum=0,ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(map.containsKey(sum)) ans=Math.max(ans,i-map.get(sum));
            else map.put(sum,i);
        }
        return ans==Integer.MIN_VALUE?0:ans;
    }
}


// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1