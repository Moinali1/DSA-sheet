class Solution {
    public boolean canPlaceFlowers(int[] fb, int n) {
        if(n>fb.length)return false;
        if(fb.length==1)
            return fb[0]==1 && n==0?true:fb[0]==0 && n<=1?true:false;
        int num=n;
        for(int i=0;i<fb.length && num!=0;i++)
        {
            if(i==0 )
            {
                if(fb[i]==0 && fb[i+1]!=1)
                {
                    num--;
                    fb[i]=1;
                }
            }
            else if(i==fb.length-1)
            {
                if(fb[i]==0 && fb[i-1]!=1)
                {
                    num--;
                    fb[i]=1;
                }
            }
            else if(fb[i]==0 && fb[i+1]!=1 && fb[i-1]!=1) 
            {
                fb[i]=1;
                num--;
            }
        }    

        return num==0;
    }
}