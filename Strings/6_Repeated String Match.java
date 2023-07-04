// https://leetcode.com/problems/repeated-string-match/description/


class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count=1;String newA=a;
        while(newA.length()<b.length()) 
        {
            newA+=a;count++;
        }
        if(rabinKarp(newA,b))return count;
        if(rabinKarp(newA+a,b))return count+1;
        return -1;
    }
    public boolean rabinKarp(String a,String b)
    {
        int i,j=0,alen=a.length(),blen=b.length();
        double aHash=0,bHash=0;
        for(i=0;i<blen;i++)
        {
            bHash+=Math.pow(10,blen-i)*(b.charAt(i)-'0');
        }
        for(i=0;i<alen;i++)
        {
            if(i-j<blen)
            {
                aHash+=Math.pow(10,blen-i)*(a.charAt(i)-'0');
            }
            else
            {
                aHash= ((aHash-(Math.pow(10,blen)*(a.charAt(j)-'0')))*10)+(10*(a.charAt(i)-'0'));
                j++;
            }
            if(aHash==bHash){
                int x=j,y=0;
                while(y<blen)
                {
                    if(a.charAt(x)!=b.charAt(y))break;
                    x++;y++;
                }
                if(y==blen)return true;
            }
        }
        return false;
    }
}