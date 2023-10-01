public class Solution{
    public static int countSetBits(int num) {       
        long count=1;
        for(long i=2;i<=num;i++){
            long n=i;
            while(n>0)
            {
                count++;
                n=n&(n-1);
            }  
        }
        return (int)count;
    }
}

public class Solution{
    public static int countSetBits(int num) {       
        long count=1;
        for(long i=2;i<=num;i++){
            long n=i;
            while(n>0)
            {
                count++;
                n=n-(n&(-n));
            }  
        }
        return (int)count;
    }
}


// only single
class Solution {
    static int setBits(int n) {
        int count=0;
            while(n>0)
            {
                count++;
                n=n&(n-1);
            }  
        return count;
    }
}
