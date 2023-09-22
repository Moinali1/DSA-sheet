class Solution {
    int dirs[][]={{-1,0},{0,-1},{1,0},{0,+1}};
    public int numEnclaves(int[][] grid) {
        if(grid.length<=2 || grid[0].length<=2)return 0;
        
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==1)bondaryCase(i,0,grid);
            if(grid[i][grid[0].length-1]==1)bondaryCase(i,grid[0].length-1,grid);
        }
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[0][j]==1)bondaryCase(0,j,grid);
            if(grid[grid.length-1][j]==1)bondaryCase(grid.length-1,j,grid);
        }
        int ans=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)ans++;
            }
        }
        return ans;
    }
    public void bondaryCase(int row,int col,int[][] grid)
    {
        if(row<0 || row>=grid.length ||col<0 ||col>=grid[0].length)return;
        if(grid[row][col]==0)return;

        grid[row][col]=0;

        for(int d[]:dirs)
        {
            bondaryCase(row+d[0],col+d[1],grid);
        }
    }
}




// another solution
class Solution {
    public int numEnclaves(int[][] grid) {
        int ans=0;
        for(int i=1;i<grid.length-1;i++)
        {
            for(int k=1;k<grid[0].length-1;k++)
            {
                if(grid[i][k]==1)
                {
                   int count=landCells(grid,i,k);
                   if(count!=-1)ans+=count;
                }
            }
        }
        return ans;
    }

    public boolean isBondary(int[][] grid,int i,int k)
    {
        return i==0 || k==0 || i==grid.length-1 || k==grid[0].length-1;
    }
    public int landCells(int grid[][],int i,int k)
    {
        if(grid[i][k]==0)return 0;
        if(isBondary(grid,i,k)) return -1;
        grid[i][k]=0;
        
        int left=landCells(grid,i,k-1);
        int right=landCells(grid,i,k+1);
        int top= landCells(grid,i-1,k);
        int bottom=landCells(grid,i+1,k);

        if(left==-1 || right==-1 || top==-1 || bottom==-1)return -1;

        return left+right+top+bottom+1;
    }
}













