class LFUCache {
    class Node{
        int key,value,freq;
        Node next,pre;
        Node(int key,int value,int freq)
        {
            this.key=key;
            this.value=value;
            this.freq=freq;
        }
    }

    class DLL{
        int DLLsize;
        Node head=new Node(0,0,0);
        Node tail=new Node(0,0,0);
        DLL()
        {
            this.DLLsize=0;
            head.next=tail;tail.pre=head;
        }
        void addNode(Node newNode)
        {
            newNode.next=head.next;
            newNode.pre=head;
            head.next.pre=newNode;
            head.next=newNode;
            DLLsize++;
        }
        void removeNode(Node cur)
        {
            cur.pre.next=cur.next;
            cur.next.pre=cur.pre;
            DLLsize--;
        }
    }

    int capacity,size,minfreq;
    HashMap<Integer,Node> cache;
    HashMap<Integer,DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.cache=new HashMap<>();;
        this.freqMap=new HashMap<>();
        this.size=0;
        this.minfreq=0;
    }
    
    public int get(int key) {
      if(cache.containsKey(key)==false)return -1;
      Node refNode=cache.get(key);
      update(refNode);
      return refNode.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0)return;
        if(cache.containsKey(key))
        {
            Node refNode=cache.get(key);
            refNode.value=value;
            update(refNode);
        }
        else 
        {
            size++;
            if(size>capacity)
            {
                DLL refList=freqMap.get(minfreq);
                cache.remove(refList.tail.pre.key);
                refList.removeNode(refList.tail.pre);
                size--;
            }
            minfreq=1;
            DLL list=freqMap.getOrDefault(1,new DLL());
            Node newNode=new Node(key,value,1);
            list.addNode(newNode);
            freqMap.put(1,list);
            cache.put(key,newNode);
        }
    }

    public void update(Node node)
    {
        DLL listToRemove= freqMap.get(node.freq);
        listToRemove.removeNode(node);

        if(node.freq==minfreq && listToRemove.DLLsize==0)minfreq++;
        node.freq++;

        DLL listToAdd= freqMap.getOrDefault(node.freq,new DLL());
        listToAdd.addNode(node);
        freqMap.put(node.freq,listToAdd);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


//  https://leetcode.com/problems/lfu-cache/description/