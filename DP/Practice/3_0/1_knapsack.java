//Bottom up tabulation 
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][]=new int[n+1][W+1];
        
        for(int i=wt[0];i<=W;i++)
        {
            if(W>=wt[0])
            {
                dp[0][i]=val[0];
            }
            else dp[0][i]=0;
        }
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                int include=0;
                if(j>=wt[i])
                include=val[i]+dp[i-1][j-wt[i]];
                int exclude=dp[i-1][j];
                
                dp[i][j]=Math.max(include,exclude);
            }
        }
    
        return dp[n-1][W];
         
    } 
    // static int findKS(int W,int idx,int wt[], int val[],int[][] dp)
    // {
    //   if(idx==0)
    //   {
    //       if(W>=wt[0])return val[0];
    //       return 0;
    //   }
    //   if(dp[idx][W]!=0)return dp[idx][W];
       
    //   int include=0;
    //   if(W>=wt[idx])
    //   include=val[idx]+findKS(W-wt[idx],idx-1,wt,val,dp);
    //   int exclude=0+findKS(W,idx-1,wt,val,dp);
       
    //   dp[idx][W]=Math.max(include, exclude);
    //   return dp[idx][W];
    // }
}



//Top down approch
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int ans=0;
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int dp[][]=new int[n+1][W+1];
        
        
        return findKS(W,n-1,wt,val,dp);
         
    } 
    static int findKS(int W,int idx,int wt[], int val[],int[][] dp)
    {
       if(idx==0)
       {
           if(W>=wt[0])return val[0];
           return 0;
       }
       if(dp[idx][W]!=0)return dp[idx][W];
       
       int include=0;
       if(W>=wt[idx])
       include=val[idx]+findKS(W-wt[idx],idx-1,wt,val,dp);
       int exclude=0+findKS(W,idx-1,wt,val,dp);
       
       dp[idx][W]=Math.max(include, exclude);
       return dp[idx][W];
    }
}



// recursive brute better

class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int ans=0;
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
          return findKS(W,n-1,wt,val);
         
    } 
    static int findKS(int W,int idx,int wt[], int val[])
    {
       if(idx==0)
       {
           if(W<=wt[0])return val[0];
           return 0;
       }
       return Math.max(val[idx]+findKS(W-wt[idx],idx-1,wt,val), 0+findKS(W,idx-1,wt,val));
    }
}


//recusive brute

// public class Solution {
// 	static int ans=0;
// 	public static int maxProfit(ArrayList<Integer> val, ArrayList<Integer> wt, int n, int w) {
// 		// Write your code here.
// 		findKS(w,0,wt,val,0,n);
// 		int valueans=ans;
// 		ans=0;
//           return valueans;
// 	}
// 	static void findKS(int W,int maxVal,ArrayList<Integer> wt, ArrayList<Integer> val, int idx,int n)
//     {
//        if(W<0)return;
//        if(idx==n)
//        {
//         ans=Math.max(ans,maxVal);
//         return;
//        }
        
//         ans=Math.max(ans,maxVal);
//         findKS(W-wt.get(idx),maxVal+val.get(idx),wt,val,idx+1,n);
//         findKS(W,maxVal,wt,val,idx+1,n);
//     }
// }


// here 3,1 repeating in left and right tree

//                                     Knapsack(5,4)

//                                        Knapsack(5,3)
//                                        /             \
//                 Knapsack(3, 2)                                                   Knapsack(5,2)
//                         /                            \                         /                                \
//           Knapsack(1,1)   Knapsack(3,1)                                      Knapsack(3,1)   Knapsack(5,1)
//           /                         \                        /                          \                          /                        \
// Knapsack(-1 ,0)  Knapsack(1,0)  Knapsack(1,0) Knapsack(3,0)
