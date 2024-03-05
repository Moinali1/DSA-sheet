class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> st= new Stack<>();
        Stack<Integer> idx= new Stack<>();
        int ans=0; idx.push(-1);

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!st.isEmpty() && c==')' && st.peek()=='(')
            {
                st.pop(); 
                idx.pop();
                ans=Math.max(ans,i-idx.peek());
            }
            else
            {
                st.push(c);
                idx.push(i);
            }
        }
        return ans;
    }
}