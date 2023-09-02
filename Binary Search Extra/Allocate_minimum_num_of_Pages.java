

// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        int res=Integer.MAX_VALUE;
        int st=A[0],end=0;
        if(N<M)return -1;
        for(int i : A)
        {
            st=Math.max(st,i);
            end+=i;
        }
        while(st<=end)
        {
            int mid=st+(end-st)/2;
            if(allocate(mid,A,M))
            {
                res=Math.min(res,mid);
                end=mid-1;
            }
            else st=mid+1;
        }
        return res;
    }
    public static boolean allocate(int mid,int[] A,int M)
    {
        int stud=1;
        int sum=0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]>mid)return false;
            if(sum+A[i]>mid)
            {
                stud++;
                sum=0+A[i];
            }
            else sum+=A[i];
        }
        if(stud>M)return false;
        return true;
    }
};