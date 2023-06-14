import java.util.*;
class Solution {

    public List<Integer> majorityElement(int[] nums) {
        int firstele=Integer.MAX_VALUE;int fvote=0;
        int secondele=Integer.MAX_VALUE;int svote=0;
        for(int i:nums)
        {
            if(i==firstele) fvote++;
            else if(i==secondele)svote++;
            else if(fvote==0)
            {
                firstele=i;fvote=1;
            }
            else if(svote==0)
            {
                secondele=i;svote=1;
            }
            else{
                fvote--;svote--;
            }
        }
        fvote=0;svote=0;
        for(int i:nums)
        {
            if(i==firstele)fvote++;
            if(i==secondele)svote++;
        }
        int n=nums.length;
        ArrayList<Integer> ans=new ArrayList<>();
        if(fvote>n/3)ans.add(firstele);
        if(svote>n/3)ans.add(secondele);
        return ans;
    }
}

// https://leetcode.com/problems/majority-element-ii/description/