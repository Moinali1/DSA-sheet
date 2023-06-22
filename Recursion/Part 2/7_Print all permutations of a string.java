class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ongoing= new ArrayList<>();
        getPermutation(ongoing,nums,0,ans,nums.length);
        return ans;
    }
    public void getPermutation(List<Integer> ongoing,int[] nums,int idx,List<List<Integer>> ans,int n)
    {
        if(idx>=n)
        {
            ans.add(new ArrayList(ongoing));
            return;
        }
        for(int i=0;i<=ongoing.size();i++)
        {
            ongoing.add(i,nums[idx]);
            getPermutation(ongoing,nums,idx+1,ans,n);
            ongoing.remove(i);
        }
    }
}