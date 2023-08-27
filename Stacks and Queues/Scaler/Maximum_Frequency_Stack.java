class FreqStack {
    HashMap<Integer,Stack<Integer>> map1= new HashMap<>();
    HashMap<Integer,Integer> map2= new HashMap<>();
    int maxOcc;

    public FreqStack() {
        this.maxOcc=0;
    }
    
    public void push(int val) {
        map2.put(val,map2.getOrDefault(val,0)+1);
        maxOcc=Math.max(maxOcc,map2.get(val));

        if(!map1.containsKey(map2.get(val))) 
            map1.put(map2.get(val),new Stack<>());
        map1.get(map2.get(val)).push(val);
    }
    
    public int pop() {
        int popVal=map1.get(maxOcc).pop();
        map2.put(popVal,maxOcc-1);
        if(map1.get(maxOcc).size()==0) maxOcc--;
        return popVal;
    }
}
