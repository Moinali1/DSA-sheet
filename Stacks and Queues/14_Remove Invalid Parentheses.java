class Solution {
    public List<String> removeInvalidParentheses(String s) {
      HashSet<String> set= new HashSet<>();
      return getValidStrings(s,invalidParenCount(s),set,new ArrayList<>());
    }

    public ArrayList<String> getValidStrings(String s,int removal,HashSet<String> set,ArrayList<String> ans)
    {
        set.add(s);
        if(removal<=0)
        {
          if(invalidParenCount(s)==0)ans.add(s);
          return ans;  
        }

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==')' || s.charAt(i)=='(')
            {
                String newS=s.substring(0,i)+s.substring(i+1);
                if(!set.contains(newS))getValidStrings(newS,removal-1,set,ans);
            }
        }
        return ans;
    }

    public int invalidParenCount(String s)
    {
        Stack<Character> st= new Stack<>();

        for(char i: s.toCharArray())
        {
            if(!st.isEmpty() && i==')' && st.peek()=='(')st.pop();
            else if(i=='(' || i==')') st.push(i);
        }

        return st.isEmpty()?0:st.size();
    }
}