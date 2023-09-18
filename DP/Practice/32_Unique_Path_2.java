//Bottom up
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int [][] dp= new int[grid.length][grid[0].length];
     
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==1)break;
            dp[i][0]=1;
        }
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[0][j]==1)break;
            dp[0][j]=1;
        }

        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)dp[i][j]=0;
                else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];

    }
}


// Top Down
// class Solution {
//     boolean reached;
//     public int uniquePathsWithObstacles(int[][] obsGrid) {
//       this.reached=false;
//       int [][] dp= new int[obsGrid.length][obsGrid[0].length];
//       for(int i[]:dp)Arrays.fill(i,-1);
//       return countPaths(0,0,obsGrid,dp);
//     }
//     int countPaths(int row,int col,int[][] obsGrid,int[][] dp)
//     {
//         if(row==obsGrid.length|| col==obsGrid[0].length) return 0;
//         if(obsGrid[row][col]==1)return 0;
//         if(row==obsGrid.length-1 && col==obsGrid[0].length-1)
//             return 1;
        
//         if(dp[row][col]!=-1)return dp[row][col];

//         int right=countPaths(row,col+1,obsGrid,dp);
//         int down=countPaths(row+1,col,obsGrid,dp);
//         dp[row][col]=right+down;
//         return dp[row][col];
//     }
// }