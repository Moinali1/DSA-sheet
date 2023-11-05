class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int s=1,e=0;
        for(int w:weights)
        {
            s=Math.max(w,s);
            e+=w;
        }
        while(s<e)
        {
            int mid=s+(e-s)/2;
            int cur=0,curDays=1;
            for(int w: weights)
            {
                cur+=w;
                if(cur>mid){
                    curDays++;
                    cur=w;
                }
            }
            if(curDays>days)s=mid+1;
            else e=mid;
        }
        return s;
    }
}