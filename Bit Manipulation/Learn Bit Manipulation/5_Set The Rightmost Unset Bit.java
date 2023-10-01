public class Solution {
    public static int setBits(int N){
        if((N^(N+1))==((N<<1)+1))return N;
        return N|N+1;
    }
}
