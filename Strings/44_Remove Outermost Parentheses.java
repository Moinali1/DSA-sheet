class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st= new Stack<>();
        StringBuilder res= new StringBuilder("");
        int i=0,j=0;
        for(j=0;j<s.length();j++)
        {
            if(!st.isEmpty() && s.charAt(j)==')' && st.peek()=='(')st.pop();
            else st.push(s.charAt(j));
            if(st.isEmpty())
            {
                if(i+1<j)
                    res.append(s.substring(i+1,j));
                i=j+1;
            }
        }
        return res.toString();
    }
}