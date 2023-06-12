import java.util.*;
class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int[] arr= new int[A.size()];
        for(int i=0;i<A.size();i++)
        {
            arr[i]=A.get(i);
        }    
        for(int i=0;i<arr.length;)
        {
            if(arr[i]!=arr[arr[i]-1])
            {
                swap(arr,i,arr[i]-1);
                
            }
            else
            {
                i++;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]!=i+1)
            {
                return new ArrayList<>(Arrays.asList(arr[i],i+1));
            }
        }
         return new ArrayList<>(Arrays.asList(-1,-1));
    }
    public void swap(int arr[],int a,int b)
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}

// another approch
class Solve {
    int[] findTwoElement(int nums[], int n) {
        int rep=0;
        for(int i :nums)
        {
          int num=Math.abs(i)-1;
          if(nums[num]<0)
          {   
              rep=num+1;
          }
          else
          {
            nums[num]=-nums[num];
          }
        }
        for(int i=0;i<nums.length;i++)if(nums[i]>0)return new int[]{rep,i+1};
        return new int[]{-1,-1};
    }
}

// https://www.interviewbit.com/problems/repeat-and-missing-number-array/