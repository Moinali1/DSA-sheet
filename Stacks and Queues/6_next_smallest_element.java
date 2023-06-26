public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans= new ArrayList<>();
        Stack<Integer> st= new Stack<>();
        st.push(-1);
        for(int i: A)
        {
            while(st.peek()>=i)st.pop();
            ans.add(st.peek());
            st.add(i);
        }
        return ans;
    }
}

// https://www.interviewbit.com/problems/nearest-smaller-element/