class Solution
{
    /*You are required to complete this method
    * ar1 : 1st array
    * ar2 : 2nd array
    */
    int maxPathSum(int ar1[], int ar2[])
    {
        int sum=0,sum1=0,sum2=0;
        int i=0,j=0;
        
        while(i<ar1.length && j<ar2.length)
        {
            if(ar1[i]<ar2[j])
            {
                sum1+=ar1[i++];
            }
            else if(ar1[i]>ar2[j])
            {
                sum2+=ar2[j++];
            }
            else
            {
                sum+=Math.max(sum1,sum2)+ar1[i];
                sum1=sum2=0;
                i++;j++;
            }
        }
        while(i<ar1.length)
            sum1+=ar1[i++];
        while(j<ar2.length)
            sum2=ar2[j++];
        
        sum+=Math.max(sum1,sum2);
        
        return sum;
    }
}