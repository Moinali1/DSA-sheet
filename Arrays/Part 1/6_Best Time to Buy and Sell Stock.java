class Solution {
    public int maxProfit(int[] p) {
        int i=0,j=1,n=p.length;
        int ans=-1,cur=0;
        while(j<n)
        {
            cur=p[j]-p[i];
            ans=Math.max(ans,cur);
            if(cur<0)i=j;
            j++;
        }
        return ans<0?0:ans;
    }
}

