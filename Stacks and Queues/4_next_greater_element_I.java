class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st= new Stack<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        st.push(-1);
        for(int i=nums2.length-1;i>-1;i--)
        {
            while(st.isEmpty()==false)
            {
                int num=st.pop();
                if(num>nums2[i] || num==-1)
                {
                    st.push(num);
                    map.put(nums2[i],num);
                    break;
                }
            }
            st.push(nums2[i]);
        }
        int[] ans= new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
            ans[i]=map.get(nums1[i]);
        
        return ans;
    }
}