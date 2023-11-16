class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	   Stack<Integer> s= new Stack<>();
	   int ans[]=new int[arr.length];
	   s.push(-1);
	   int i=arr.length-1;
	   int j=ans.length-1;
	   while(i>-1)
	   {
           while(s.peek()!=-1 && s.peek()>=arr[i])
           {
               s.pop();
           }
           ans[j]=s.peek();
	       s.push(arr[i]);
	       i--;
	       j--;
	       }
	   return ans;
	   }
	   
	} 