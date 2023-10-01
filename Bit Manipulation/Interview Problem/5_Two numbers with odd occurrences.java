class Solution
{
    public int[] twoOddNum(int arr[], int n)
    {
       int fullXOR=0;
        for(int num:arr) fullXOR^=num;
        int rSetPos=getRightSetPos(fullXOR);
        
        int first=0,second=0;
        for(int num:arr)
        {
            if(!checkPosBitIsSet(num,rSetPos))first^=num;
        }
        for(int num:arr)
        {
            if(checkPosBitIsSet(num,rSetPos))second^=num;
        }
        
        if(second>first)return new int[]{second,first};
        return new int[]{first,second};
    }
    boolean checkPosBitIsSet(int n,int idx)
    {
        int res=(n &(1<<(idx-1)));
        return res!=0?true:false;
    }
    int getRightSetPos(int n)
    {
        int res=(n&(-n));
        return Integer.numberOfTrailingZeros(res)+1;
    }
}