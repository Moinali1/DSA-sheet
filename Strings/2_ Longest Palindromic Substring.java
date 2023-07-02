class Solution {
    public String longestPalindrome(String s) {
        int i=0,j;
        String ans=s.charAt(0)+"";
       for(i=0;i<s.length()-1;i++)
       {
           String even="",odd="";
           if(i+1<s.length() && s.charAt(i)==s.charAt(i+1))even=checkForPalin(s,i,i+1);
           if(i+2<s.length() && s.charAt(i)==s.charAt(i+2))odd=checkForPalin(s,i,i+2);

           if(ans.length()<even.length()) ans=even;
           if(ans.length()<odd.length()) ans=odd;
       }
       return ans;
    }
    public String checkForPalin(String s,int i,int j)
    {
        while(i>-1 &&j<s.length())
        {
            if(s.charAt(i)!=s.charAt(j))break;
            i--;j++;
        }
        return s.substring(i+1,j);    
    }
}