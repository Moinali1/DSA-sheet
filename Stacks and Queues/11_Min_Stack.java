class MinStack {
    Long min=(long)0;    
    Stack<Long> st= new Stack<>();

    public void push(int value) {
        long val=(long)value;
        if(st.isEmpty())min=val;
        if(val<min)
        {
            st.push(2*val-min); 
            min=val;
        }
        else 
          st.push(val);
    }
    
    public void pop() {
        if(st.peek()>=min)st.pop();
        else{
            min=2*min-st.pop();
        }
    }
    public int top() {
        if(st.peek()<min)return min.intValue();
        else return st.peek().intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}


// https://leetcode.com/problems/min-stack/description/