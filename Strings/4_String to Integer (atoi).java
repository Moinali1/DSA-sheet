class Solution {
    public int myAtoi(String s) {
        int i=0,ans=0;
        char sign='#';

            while(i<s.length() && s.charAt(i)==' ')i++;

            if(i<s.length() && (s.charAt(i)=='-' || s.charAt(i)=='+')) 
            { 
              sign=s.charAt(i)=='-'?'-':'+';
              i++;
            }
            while(i<s.length())
            {
                int num= s.charAt(i)-'0';
                if(sign=='#')sign='+';
                if(num<0 || num>9)break;
                if(ans>Integer.MAX_VALUE/10 || ans==Integer.MAX_VALUE/10 && num>7)
                    return sign=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE;
                ans=ans*10+num;
                i++;    
            }
        return sign=='-'?-ans:ans;
    }
}