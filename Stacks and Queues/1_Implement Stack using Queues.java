class MyStack {
    Queue<Integer> que= new LinkedList<>();
    public void push(int x) {
        que.add(x);
        for(int i=0;i<que.size()-1;i++)que.add(que.remove());
    }
    public int pop() {
       return que.remove(); 
    }
    public int top() {
        return que.peek();
    }
    public boolean empty() {
        return que.isEmpty();
    }
}