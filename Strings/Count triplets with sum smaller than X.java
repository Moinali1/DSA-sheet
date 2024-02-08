class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
    int i,j,k,count=0;
    Arrays.sort(arr);
    for(i=0;i<n-2;i++)
    {
        j=i+1;   
        k=n-1;
        while(j<k)
        {
            if((arr[i]+arr[j]+arr[k])<sum)
            {
             count+=k-j; 
             j++;
            }
            else if((arr[i]+arr[j]+arr[k])>=sum)
            {
             k--;  
            }
        }
    }
    return count;
    }
}

