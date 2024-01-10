class Solution {
    public int countPrimes(int n) {
        int[] arr= new int[n+1];
        for(int i=2;i*i<n;i++)
        {
            if(arr[i]!=1)
                for(int j=2;j*i<n;j++)
                    arr[j*i]=1;
            
        }
        int count=0;
        for(int i=2;i<n;i++)if(arr[i]!=1)count++;
        return count;
    }
}