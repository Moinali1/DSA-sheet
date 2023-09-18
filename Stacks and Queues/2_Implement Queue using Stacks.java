//O(1) amortized
class MyQueue {
    Stack<Integer> input= new Stack<>();
    Stack<Integer> output= new Stack<>();

    public void push(int x) {
        input.push(x);    
    }
    
    public int pop() {
       if(output.isEmpty()) peek();
       return output.pop(); 
    }
    
    public int peek() {
        if(output.isEmpty())
            while(!input.isEmpty())output.push(input.pop());
        
        return output.peek();
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}







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