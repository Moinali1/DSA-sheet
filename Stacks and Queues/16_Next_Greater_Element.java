class Solution {
    final int BASE=Integer.MIN_VALUE;
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st= new Stack<>();
        st.push(Integer.MIN_VALUE); // not -1 because -ve are aldo there

        for(int i=nums.length-1;i>=0;i--) //pushing all the ele from back
            st.push(nums[i]);

        int res[]=new int[nums.length];

        for(int i=nums.length-1;i>=0;i--) // doing similar to next greater element 
        {
            while(st.peek()!=BASE && st.peek()<=nums[i])
                st.pop();     
            res[i]=st.peek()==BASE?-1:st.peek();    
            st.push(nums[i]);
        }
        return res;
    }
}   

// another way
    public int[] nextGreaterElements(int[] A) {
        int n = A.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
                res[stack.pop()] = A[i % n];
            stack.push(i % n);
        }
        return res;
    }