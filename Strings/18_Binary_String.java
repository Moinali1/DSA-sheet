class Solution
{
    //Function to count the number of substrings that start and end with 1.
    public static int binarySubstring(int a, String str)
    {
        int oneCount=0;
        for(int i=0;i<str.length();i++)if(str.charAt(i)-'0'==1)oneCount++;
        return ((oneCount-1)*(oneCount))/2;
    }
}