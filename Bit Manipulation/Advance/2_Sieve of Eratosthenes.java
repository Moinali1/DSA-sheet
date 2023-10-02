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
// https://leetcode.com/problems/count-primes/

//TLE
// class Solution {
//     public int countPrimes(int n) {
//         int count=0;
//         for(int i=2;i<n;i++)
//             if(isPrime(i))count++;
//         return count;    
//     }
//     static boolean isPrime(int n)
//     {
//         for(int i=2;i*i<=n;i++)
//         {
//             if(n%i==0)return false;
//         }
//         return true;
//     }
// }