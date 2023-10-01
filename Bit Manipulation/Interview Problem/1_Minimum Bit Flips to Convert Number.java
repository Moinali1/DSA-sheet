class Solution {
    public int minBitFlips(int start, int goal) {
        int res= start^goal;
        return Integer.bitCount(res);
    }
}

class Solution {
    public int minBitFlips(int start, int goal) {
        int res= start^goal;
        int cnt=0;
        while(res>0)
        {
            if((res&1)==1)cnt++;
            res=res>>1;
        }
        return cnt;
    }
}