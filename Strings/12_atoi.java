class Solution {
    public int myAtoi(String s) {
        if(s.length()==0)return 0;
        int ans=0;
        int i=0;
        while( i < s.length() && s.charAt(i) == ' ')i++;

        char sign='+';
        if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            sign=s.charAt(i);i++;
        }
        while(i<s.length())
        {
            int c=s.charAt(i)-'0';
            if(c<0 || c>9)break;
            else if(ans>Integer.MAX_VALUE/10 || (ans==Integer.MAX_VALUE/10 && c>7))
                return sign=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
            else{
                ans=ans*10+(s.charAt(i)-'0');
                i++;
            }
        }
        return sign=='-'?-ans:ans;
    }
}