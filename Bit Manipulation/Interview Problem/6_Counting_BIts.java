class Solution {
    public int[] countBits(int n) {
        int ans[]= new int[n+1];
        for(int i=1;i<=n;i++)
        {
            int num=i;
            while(num>0)
            {
                ans[i]++;
                num=num&(num-1);
            }
        }
        return ans;
    }
}