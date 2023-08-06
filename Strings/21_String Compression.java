class Solution {
    public int compress(char[] chars) {
        if(chars.length==1)return 1;
        int i=0,j=0,idx=0;
        
        while(j<=chars.length)
        {
            if(j==chars.length || chars[i]!=chars[j])
            {
                int count=j-i;
                chars[idx++]=chars[i];
                if(count!=1)
                {
                    int len=(int)Math.log10(count)+1;
                    while(len!=0)
                    {
                        chars[idx++]=(char)(((char)(count/Math.pow(10,len-1)))+'0');
                        count=(int)(count%Math.pow(10,len-1));
                        len--;
                    }
                }
                i=j;
            }
            j++;
        }
        return idx; 
    }
}