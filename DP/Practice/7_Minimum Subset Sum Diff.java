// https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution
{

	public int minDifference(int arr[], int N) 
	{ 
       int sum=0;
       for(int i:arr)sum+=i;
       
	   int[][] dp= new int[N+1][sum+1];
       
        for (int i = 1; i <= N; i++) 
             for (int w = 1; w <= sum; w++) 
                    dp[i][w] = -1 ;
        
       
       for(int i=1;i<=N;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                int incl=0;
                if(j>=arr[i-1])incl=arr[i-1]+dp[i-1][j-arr[i-1]];
                int excl=dp[i-1][j];
                
                dp[i][j]=Math.max(incl,excl);
            }
        }
        
        int ans=Integer.MAX_VALUE;;
        for(int i=0;i<=sum/2;i++)ans=Math.min(ans,sum-(2*dp[N][i]));
        
        return ans;
    
	} 

}

// top down memoization - this will not work as recursion does not go to each block iteratively

// class Solution
// {

// 	public int minDifference(int arr[], int N) 
// 	{ 
//       int sum=0;
//       for(int i:arr)sum+=i;
       
// 	   int[][] dp= new int[N+1][sum+1];
       
//          for (int i = 1; i <= N; i++) 
//              for (int w = 1; w <= sum; w++) 
//                     dp[i][w] = -1;
        
//         getSubSum(arr,sum,N,dp);
        
//         int ans=Integer.MAX_VALUE;
//         for(int i=0;i<=sum/2;i++)ans=Math.min(ans,sum-(2*dp[N][i]));
        
//         return ans;
        
        
        
// 	} 
// 	static int getSubSum(int[] arr,int sum,int idx,int dp[][]){
//         if(idx==0 || sum==0)return 0;
        
//         if(dp[idx][sum]!=-1)return dp[idx][sum];
        
//         int incl=0;
//         if(sum>=arr[idx-1])incl=arr[idx-1]+getSubSum(arr,sum-arr[idx-1],idx-1,dp);
//         int excl= getSubSum(arr,sum,idx-1,dp);
        
//         dp[idx][sum]=Math.max(incl,excl);
        
//         return dp[idx][sum];
//     }
// }



// top down for take not take- this will work
// class Solution {
//     public int minDifference(int[] arr, int N) {
//         int sum = 0;
//         for (int num : arr) sum += num;

//         // Create a memoization table to store intermediate results
//         int[][] dp = new int[N + 1][sum + 1];
//         for (int i = 0; i <= N; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i][j] = -1; // Initialize with -1 to indicate not calculated
//             }
//         }

//         return findMinDifference(arr, N, sum, 0, dp);
//     }

//     private int findMinDifference(int[] arr, int idx, int totalSum, int currentSum, int[][] dp) {
//         if (idx == 0) {
//             return Math.abs(totalSum - 2 * currentSum);
//         }

//         if (dp[idx][currentSum] != -1) {
//             return dp[idx][currentSum];
//         }

//         int include = findMinDifference(arr, idx - 1, totalSum, currentSum + arr[idx - 1], dp);
//         int exclude = findMinDifference(arr, idx - 1, totalSum, currentSum, dp);

//         dp[idx][currentSum] = Math.min(include, exclude);
//         return dp[idx][currentSum];
//     }
// }