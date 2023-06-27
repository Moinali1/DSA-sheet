class Solution {
    class Pair{
        int index,height;
        Pair(int idx,int val)
        {
            this.index=idx;this.height=val;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n= heights.length;
        Stack<Pair> st= new Stack<>();
        st.push(new Pair(-1,0));
        int[] leftH=new int[n];
        int[] rightH=new int[n];

        for(int i=0;i<n;i++)
        {
            while(st.size()>1 && st.peek().height>=heights[i])st.pop();
            leftH[i]=st.peek().index+1;
            st.push(new Pair(i,heights[i]));
        }
        st.empty();
        st.push(new Pair(n,0));
        for(int i=n-1;i>=0;i--)
        {
            while(st.size()>1 && st.peek().height>=heights[i])st.pop();
            rightH[i]=st.peek().index-1;
            st.push(new Pair(i,heights[i]));
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,((rightH[i]-leftH[i]+1)*heights[i]));
        }
        return ans;
    }
}


















