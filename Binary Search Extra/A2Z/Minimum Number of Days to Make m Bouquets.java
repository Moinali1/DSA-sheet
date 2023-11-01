class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)return -1;
        int s=1,e=0;
        for(int i:bloomDay)e=Math.max(e,i);
        while(s<e)
        {
            int mid=s+(e-s)/2;
            int bouq=0;
            for(int i=0,flower=0;i<bloomDay.length;i++)
            {
                if(bloomDay[i]>mid)flower=0;
                else if(++flower>=k)
                {
                    flower=0;
                    bouq++;
                }
            }
            if(bouq<m)s=mid+1;
            else e=mid;
        }
        int bouq=0;
        for(int i=0,flower=0;i<bloomDay.length;i++)
            {
                if(bloomDay[i]>s)flower=0;
                else if(++flower>=k)
                {
                    flower=0;
                    bouq++;
                }
            }

        return bouq>=m?s:-1;
    }
}