class Sol
{
    public static int NeedleinHaystack(String hs, String n) 
    {
        if(hs.length()==0||n.length()==0)return 0;
        //creating a lps array.
        int lps[]= new int[n.length()];
        int i=0,j=1;lps[0]=0;
        while(j<n.length())
        {
            if(n.charAt(i)==n.charAt(j))
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
        
        // after creating lps array searching for pattern
        i=0;j=0;
        
        while(i<hs.length() && j<n.length())
        {
            if(hs.charAt(i)==n.charAt(j)){
                i++;j++;
            }
            else
            {
               if(j==0)i++;    
               else
               {
                   j=lps[j-1];
               }
            }
        }
        return j==n.length()?i-j:-1;
    }
}
