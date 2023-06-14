import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        int ans=0,cur=0;
        HashSet<Integer> set= new HashSet<>();
        for(int i:nums)set.add(i);
        for(int i:set)
        {
            if(!set.contains(i-1))
            {
                cur=1;i++;
                while(set.contains(i)){cur++;i++;}
                ans=Math.max(ans,cur);
            }
        }
        return ans;
    }
}





// Iterator value = set.iterator();
//         // Displaying the values after iterating through the set
//         System.out.println("The iterator values are: ");
//         while (value.hasNext()) {
//             System.out.println(value.next());
//         }


// https://leetcode.com/problems/longest-consecutive-sequence/description/