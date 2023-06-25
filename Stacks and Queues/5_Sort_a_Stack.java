class GfG{
	public Stack<Integer> sort(Stack<Integer> st)
	{
	    if(st.isEmpty())return st;
	    int ele=st.pop();
	    sort(st);
	    getPosition(st,ele);
	    return st;
        
	}
	public void getPosition(Stack<Integer> st,int ele)
	{
	    if(st.isEmpty())
	    { 
	        st.push(ele);
	        return;
	    }
	    if(st.isEmpty() || st.peek()<ele)
	    {
	        st.push(ele);
	    }
	    else
	    {
	        int cur=st.pop();
	        getPosition(st,ele);
	        st.push(cur);
	    }
	}
}




// return type solution

class GfG{
	public Stack<Integer> sort(Stack<Integer> st)
	{
	    if(st.isEmpty())return st;
	    int ele=st.pop();
	    sort(st);
	    return getPosition(st,ele);
        
	}
	public Stack<Integer> getPosition(Stack<Integer> st,int ele)
	{
	    if(st.isEmpty())
	    { 
	        st.push(ele);
	        return st;
	    }
	    if(st.isEmpty() || st.peek()<ele)
	    {
	        st.push(ele);
	    }
	    else
	    {
	        int cur=st.pop();
	        getPosition(st,ele);
	        st.push(cur);
	    }
	    return st;
	}
}