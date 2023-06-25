class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char i: s.toCharArray())
        {
            if(i=='{' || i=='(' || i=='[') st.push(i);
            else if(st.isEmpty() || st.pop()!=inverse(i))return false;
        }
        return st.isEmpty();
    }
    public char inverse(char i)
    {
        if(i==')')return '(';
        else if(i==']')return '[';
        else return '{';
    }
}