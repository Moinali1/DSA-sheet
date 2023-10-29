class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    //Function to extract minimum value in heap and then to store 
    //next minimum value at first index.
    int extractMin()
    {
        if(heap_size<=0)return -1;
        int min=harr[0];
        
        harr[0]=harr[heap_size-1];
        harr[heap_size-1]=0;
        heap_size--;
        
        MinHeapify(0);
        return min;
    }
    
    
    // Function to insert a value in Heap.
    void insertKey(int k) 
    {
        if (heap_size == capacity) {
            return;
        }
        harr[heap_size]=k;
        int idx=heap_size;
        
        while(idx!=0 && harr[parent(idx)]>harr[idx])
        {
            int temp=harr[idx];
            harr[idx]=harr[parent(idx)];
            harr[parent(idx)]=temp;
            idx=parent(idx);
        }
        
        heap_size++;
    }
  

    //Function to delete a key at ith index.
    // void deleteKey(int i) 
    // {
    //     if(heap_size<=0 || i>= heap_size)return;
    //     harr[i]=harr[heap_size-1];
    //     harr[heap_size-1]=0;
    //     heap_size--;
    //     MinHeapify(i);
    // }
    
    void deleteKey(int i) {
        // Your code here.
        if(heap_size<=0 || i>= heap_size )
            return;
        this.decreaseKey(i, Integer.MIN_VALUE);
        this.extractMin();
    }
    
    void decreaseKey(int i, int new_val) 
    {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }
    
    
    /* You may call below MinHeapify function in above codes. Please do not delete this code if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int left=left(i);
        int right=right(i);
        int smallest=i;
        
        if(left<heap_size && harr[smallest]>harr[left])smallest=left;
        if(right<heap_size && harr[smallest]>harr[right])smallest=right;
        
        if(smallest!=i)
        {
            int temp= harr[i];
            harr[i]=harr[smallest];
            harr[smallest]=temp;
            
            MinHeapify(smallest);
        }
    }
}