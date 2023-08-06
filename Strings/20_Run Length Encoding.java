class GfG
 {
	String encode(String str)
	{
        int i=0,j=0;
        StringBuilder ans= new StringBuilder("");
        
        while(j<str.length())
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                ans.append((str.charAt(i)+"")+(j-i));
                i=j;
            }
            j++;
        }
        ans.append((str.charAt(i)+"")+(j-i));
        return ans.toString();
	}
 }