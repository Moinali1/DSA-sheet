class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> ans= new ArrayList<>();
      Arrays.sort(nums);
      getSubsets(0,new ArrayList(),nums,ans,nums.length);
      return ans;
    }
    public void getSubsets(int idx,ArrayList<Integer> ongoing,int[] nums,List<List<Integer>> ans,int n){
        if(idx>n)return;
        ans.add(new ArrayList(ongoing));
        for(int i=idx;i<n;i++)
        {
            if(i==idx || nums[i]!=nums[i-1])
            {
                ongoing.add(nums[i]);
                getSubsets(i+1,ongoing,nums,ans,n);
                ongoing.remove(ongoing.size()-1);
            }
        }
    }
}