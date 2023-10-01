public class Solution {
    public static String oddEven(int n){
       int res= n&1;
       return res==0?"even":"odd";
    }
}