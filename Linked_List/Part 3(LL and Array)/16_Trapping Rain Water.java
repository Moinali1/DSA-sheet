//Optimized Solution
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int Lmax=0,Rmax=0,ans=0;
        int i=0,j=n-1;

        while(i<j)
        {
            if(height[i]<=height[j])
            {
                if(Lmax>height[i]) ans+=Lmax-height[i];
                else Lmax=height[i];
                i++;
            }
            else
            {
                if(Rmax>height[j]) ans+=Rmax-height[j];
                else Rmax=height[j];
                j--;
            }
        }
        return ans;
    }
}


// Better Solution
class Soltion {
    public int trap(int[] h) {
        int[] maxLR=new int[h.length];
        int[] maxRL=new int[h.length];
        int ans=0;
        maxLR[0]=h[0];maxRL[h.length-1]=h[h.length-1];
        int i=1,j=h.length-2;
        for(i=i;i<h.length;i++)
        {
            maxLR[i]=Math.max(maxLR[i-1],h[i]);
            maxRL[j]=Math.max(maxRL[j+1],h[j]);
            j--;
        }
        for(int k=0;k<h.length;k++)
        {
            ans+=(Math.min(maxLR[k],maxRL[k]))-h[k];
        }
        return ans;
    }
}