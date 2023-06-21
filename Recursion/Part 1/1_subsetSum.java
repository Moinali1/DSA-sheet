class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans= new ArrayList<>();
        findSubset(0,0,arr.size(),arr,ans);
        return ans;
    }
    void findSubset(int num,int idx,int len,ArrayList<Integer> arr,ArrayList<Integer> ans)
    {
        if(idx>=len)
        {   ans.add(num);
            return;
        }
        findSubset(num+arr.get(idx),idx+1,len,arr,ans);
        findSubset(num,idx+1,len,arr,ans);
    }
}