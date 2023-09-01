class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       Deque<Integer> idxque=new LinkedList<>();
       int ans[]= new int[nums.length-k+1];

       for(int i=0;i<nums.length;i++)
       {
           if(!idxque.isEmpty() && i-idxque.getFirst()==k)idxque.removeFirst();
           while(!idxque.isEmpty() && nums[idxque.getLast()]<=nums[i])idxque.removeLast();
           idxque.add(i);
           if(i>=k-1)ans[i-k+1]=nums[idxque.getFirst()];
       }

       return ans;
    }
}