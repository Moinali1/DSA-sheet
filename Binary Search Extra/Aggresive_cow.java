
// https://practice.geeksforgeeks.org/problems/aggressive-cows/0
// User function Template for Java
class Solution {
    
    public static int solve(int n, int k, int[] stall) 
    {
    Arrays.sort(stall);
    int st=0,end=stall[n-1];
    while(st<=end)
    {
        int mid=st+(end-st)/2;
        if(placeCow(stall,k,mid))
        {
            st=mid+1;
        }
        else end=mid-1;
    }
    return end;
    }
    public static boolean placeCow(int[] arr,int k,int dis)
    {
        int cow=1;
        int ele=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-ele>=dis)
            {
                cow++;
                ele=arr[i];
                if(cow==k)return true;
            }
        }
        return false;
    }
}