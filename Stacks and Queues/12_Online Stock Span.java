class StockSpanner {
    Stack<int[]> st= new Stack<>();
    StockSpanner(){
        this.st.push(new int[]{Integer.MAX_VALUE,-1});
    }
    int index=0;
    public int next(int price) {
        while(price>=st.peek()[0])st.pop();
        int ans=index - st.peek()[1];
        st.push(new int[]{price,index++});
        return ans;
    }
}
