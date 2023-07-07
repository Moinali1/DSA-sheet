class Solution {
    public int strStr(String haystack, String needle) {
        int lps[]=new int[needle.length()];
        int i=0,j=1;
        while(j<needle.length())
        {
            if(needle.charAt(i)==needle.charAt(j))
            {
                lps[j]=i+1;
                i++;j++;
            }
            else if(i>0)i=lps[i-1];
            else 
            {lps[j]=0;j++;};
        }
        i=0;j=0;
        while(j<haystack.length() && i<needle.length())
        {
            if(haystack.charAt(j)==needle.charAt(i))
            {
                i++;j++;
            }
            else if(i>0)
            {
                i=lps[i-1];
            }
            else j++;
        }
        return i>=needle.length()?j-needle.length():-1;
    }
}