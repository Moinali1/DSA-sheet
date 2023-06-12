import java.util.* ;
import java.io.*; 
class Solution {
    public static long count=0;
    public static long getInversions(long arr[], int n) {
        int i=0,j=arr.length;
        sort(arr,i,j);
        return count;
    }
    public static void sort(long arr[],int i,int j)
    {
        if(j-i==1)return;
        int mid= (i+j)/2;
        
        sort(arr,i,mid);
        sort(arr,mid,j);
        
        merge(arr,i,mid,j);
    }
    public static void merge(long[] arr,int st,int mid,int end)
    {
        int i=st,j=mid;
        while(j<end)
        {
            if(arr[i]>arr[j])
            {
                count+=mid-i;
                i=st;j++;
            }
            else{
             i++;
             if(i==mid)break;
            }
        }
        i=st;j=mid;int k=0;
        long ans[]=new long[end-st];
        while(i<mid && j<end)
        {
            if(arr[i]<arr[j])
            {
                ans[k]=arr[i];
                i++;
            }
            else
            {
                ans[k]=arr[j];
                j++;
            }
            k++;
        }
        
        while(i<mid)
        {
         ans[k]=arr[i];
         i++;k++;   
        }
        
        while(j<end)
        {
         ans[k]=arr[j];
         j++;k++;   
        }
        end--;k--;
        while(k>=0)
        {
            arr[end--]=ans[k--];
        }
        
    }
}