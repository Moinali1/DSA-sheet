//Revision Done
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first=strs[0],last=strs[strs.length-1];
        int i=0;
        for(i=i;(i<first.length() && i<last.length());i++)
        {
            if(first.charAt(i)!=last.charAt(i))break;
        }
        return first.substring(0,i);
    }
}