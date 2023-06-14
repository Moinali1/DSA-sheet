class Solution {
    public int reversePairs(int[] nums) {
      int n=nums.length;
      return (int)sort(nums,0,n);    
    }
    public long sort(int[] arr,int s,int e)
    {
        int count=0;
        if(e-s==1)return count;
        int m=s+(e-s)/2;
        count+=sort(arr,s,m);
        count+=sort(arr,m,e);
        count+=countInv(arr,s,m,e);
        return count;
    }
    public static long countInv(int[] arr,int s,int m,int e){
        int temp[]= new int[e-s];
        int i=s,j=m,k=0;long count=0;
        while(i<m && j<e)
        {
            double num=((double)arr[i]/2);
            if(num>arr[j])
            {
                count+=m-i;
                j++;
            }
            else i++;
        }
        i=s;j=m;
        while(i<m && j<e)
        {
            if(arr[i]<=arr[j])
            {
                temp[k]=arr[i];
                i++;
            }
            else
            {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<m)
        {
            temp[k]=arr[i];
            i++;k++;
        }
        while (j<e)
        {
            temp[k]=arr[j];
            j++;k++;
        }
        e--;k--;
        while(k>=0)
        {
            arr[e--]=temp[k--];
        }
        return count;
    }
}