class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)set.add(i);
        int count=0,ans=0;

        for(int i:nums)
        {
            if(!set.contains(i-1))
            {
                int cur=i;
                while(set.contains(i))
                {
                    count++;
                    i++;
                }
                ans=Math.max(count,ans);
                count=0;
            }
        }
        return ans;
    }
}