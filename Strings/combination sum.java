class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ongoing= new ArrayList<>();
        getCombinations(target,0,ongoing,ans,candidates,candidates.length);
        return ans;
    }
    public void getCombinations(int target,int idx,List<Integer> ongoing,List<List<Integer>> ans,int[] candi,int n)
    {
        if(target==0)
        {
            ans.add(new ArrayList(ongoing));
            return;
        }
        for(int i=idx;i<n;i++)
        {
            if(target-candi[i]>=0)
            {
                ongoing.add(candi[i]);
                getCombinations(target-candi[i],i,ongoing,ans,candi,n);
                ongoing.remove(ongoing.size()-1);
            }
        }
    }

}