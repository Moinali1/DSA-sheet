//bottom up
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size=triangle.size();
        for(int i=size-2;i>=0;i--)
        {
            int rowsize=triangle.get(i).size();
            for(int j=rowsize-1;j>=0;j--)
            {
                triangle.get(i).set(j,triangle.get(i).get(j) +
                                      Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}

//top down
// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int dp[][]= new int[triangle.size()][triangle.size()];
//         for(int i[]:dp)Arrays.fill(i,-1);
//         return minPath(0,0,triangle,dp);
//     }
//     int minPath(int row,int col,List<List<Integer>> triangle,int[][] dp)
//     {
//         if(row==triangle.size())return 0;
//         if(dp[row][col]!=-1)return dp[row][col];

//         dp[row][col]=triangle.get(row).get(col)+Math.min(minPath(row+1,col,triangle,dp),minPath(row+1,col+1,triangle,dp));
//         return dp[row][col];
//     }
// }
