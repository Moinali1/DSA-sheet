public class Solution {
    public static int findXOR(int L, int R){
       return getXorTill(R)^getXorTill(L-1);
    }
    static int getXorTill(int n)
    {
        int res=n%4;
        return res==0?n:res==1?1:res==2?n+1:0;
    }
}

//TLE
public class Solution {
    public static int findXOR(int L, int R){
       int xors=0;
       for(int i=L;i<=R;i++) xors^=i;
       return xors;
    }
}
