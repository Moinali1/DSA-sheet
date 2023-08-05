
//Rabin Karp
class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    {
        double xcode=0;int ans=-1;
    
        for(int i=0;i<x.length();i++)
        {
            xcode+=x.charAt(i)*Math.pow(10,x.length()-i);
        }
        int i=0,j=0;double curCode=0;
        while(j<s.length())
        {
            if(j-i+1<=x.length())
                curCode+=s.charAt(j)*Math.pow(10,x.length()-(j-i));
            else
            {
                curCode=((curCode-(s.charAt(i)*Math.pow(10,x.length())))*10)+s.charAt(j)*10;
                i++;
            }
            if(xcode==curCode)
            {
                int n=0,m=i;
                for(n=0;n<x.length();n++)
                {
                    if(s.charAt(m)!=x.charAt(n))break;
                    m++;
                }
                if(n==x.length() && m-i==x.length()) 
                {
                    ans=i;break;
                }
            }
            j++;
        }
        return ans;
    }
}