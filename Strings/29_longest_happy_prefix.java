class Solution {
    public String longestPrefix(String s) {
        int lps[]= new int[s.length()];
        int i=0,j=1;lps[0]=0;
        while(j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                lps[j]=i+1;
                i++;j++;
            }
            else
            {
                if(i==0)
                {
                    lps[j]=0;
                    j++;
                }
                else i=lps[i-1];  
            }
        }
        return s.substring(0,lps[s.length()-1]);
    }
}