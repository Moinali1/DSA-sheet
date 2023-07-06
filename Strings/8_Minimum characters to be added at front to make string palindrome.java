class Solution {
    public static int minChar(String str) {
       int ans=0;
       int i,j;
       
       for(int x=str.length()-1;x>=0;x--)
       {
           i=0;j=x;
           while(i<j)
            {
                if(str.charAt(i)!=str.charAt(j))
                {
                    ans++;
                    break;
                }
                i++;j--;
            }
            if(i>=j)return ans;
       }
       return ans;
    }
}