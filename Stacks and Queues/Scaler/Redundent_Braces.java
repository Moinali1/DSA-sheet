public class Solution {
    public int braces(String A) {
        
        Stack<Character> st= new Stack<>();
        
        for(char i:A.toCharArray())
        {
            if(!st.isEmpty() && st.peek()=='(' && i==')')return 1;
            else if(!st.isEmpty() && i==')'){
                while(st.peek()!='(') st.pop();
                st.pop();
            }
            else if(i=='+' ||i=='-' ||i=='*' ||i=='/' || i=='(' ||i==')')st.push(i);
        }
        return 0;
    }
}

// https://www.interviewbit.com/problems/redundant-braces/