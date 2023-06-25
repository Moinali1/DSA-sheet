class MyQueue {
    Stack<Integer> pro=new Stack<>();
    Stack<Integer> unpro=new Stack<>();

    public void push(int x) {
        while(pro.isEmpty()==false)unpro.push(pro.pop());
        pro.push(x);
        while(unpro.isEmpty()==false)pro.push(unpro.pop());  
    }
    public int pop() {
     return pro.pop();   
    }
    
    public int peek() {
        return pro.peek();
    }

    public boolean empty() {
        return pro.isEmpty();
    }
}