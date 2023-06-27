class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> que= new LinkedList<>();
        int ans[]= new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++)
        {
            if(!que.isEmpty() && i-que.getFirst()>=k)que.removeFirst();
            while(!que.isEmpty() && nums[que.getLast()]<=nums[i])que.removeLast();
            que.addLast(i);

            if(i>=k-1)ans[i-k+1]=nums[que.getFirst()];
        }
        return ans;
    }
}