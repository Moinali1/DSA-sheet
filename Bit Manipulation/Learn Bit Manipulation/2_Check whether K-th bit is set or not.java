public class Solution {
    static boolean isKthBitSet(int n, int k)
{
    int res= n & (1<<(k-1));
    return res==0?false:true;
}
}