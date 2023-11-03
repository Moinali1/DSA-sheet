class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans= new ArrayList<>();
        // Stack<Integer> st= new Stack<>();
        int idx=0;

        for(int i=1;i<=n&& idx<target.length;i++)
        {
            if(target[idx]==i)
            {
                ans.add("Push");
                idx++;
            }
            else 
            {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}