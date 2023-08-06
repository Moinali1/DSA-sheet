
class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String s1, String s2)
    {
        if(s1.length()!=s2.length())return false;
        if(s1.length()==1)return s1.charAt(0)==s2.charAt(0)?true:false;
        int i=0;
        while(i<s1.length())
        {
            if(s1.charAt(i)!=s2.charAt((i+2)%s2.length()))break;
            i++;
        }
        if(i==s1.length())return true;
        i=0;
        while(i<s1.length())
        {
            if(s1.charAt((i+2)%s1.length())!=s2.charAt(i))break;
            i++;
        }
        if(i==s1.length())return true;
        return false;
    }
    
}