class Solution {
    public int minPathSum(int[][] grid) {
        
        for(int j=1;j<grid[0].length;j++)
            grid[0][j]+=grid[0][j-1];

        for(int i=1;i<grid.length;i++)
            grid[i][0]+=grid[i-1][0];    

        for(int i=1;i<grid.length;i++)
        {
            for(int j=1;j<grid[0].length;j++)
            {
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }    

        return grid[grid.length-1][grid[0].length-1];
    }
}

//recursive TLE
// class Solution {
//     public int minPathSum(int[][] grid) {
//         return getMinPath(0,0,grid);
//     }

//     int getMinPath(int row,int col,int[][]grid){
//         if(row==grid.length-1 && col==grid[0].length-1)return grid[row][col];
//         if(!isValidSpace(row,col,grid))return 201;
//         return Math.min(grid[row][col]+getMinPath(row+1,col,grid),grid[row][col]+getMinPath(row,col+1,grid));
//     }

//     boolean isValidSpace(int row,int col,int[][] grid)
//     {
//         return row<grid.length && row>=0 && col<grid[0].length && col>=0; 
//     }
// }