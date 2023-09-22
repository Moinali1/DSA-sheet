//using bsf
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
     Queue<int[]> que= new LinkedList<>();
     if(grid[0][0]==1 || grid[grid.length-1][grid.length-1]==1)return -1;
     que.add(new int[]{0,0});
     for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                if(grid[i][j]==1)grid[i][j]=Integer.MIN_VALUE;
                if(grid[i][j]==0)grid[i][j]=Integer.MAX_VALUE;
            }
        }
      int[][] dirs = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };  
      grid[0][0]=0;  

     while(!que.isEmpty())   
     {
         int val[]=que.remove();
         int i=val[0],j=val[1];

         for(int d[]:dirs)
         {
            if(isValid(i+d[0],j+d[1],grid) && grid[i+d[0]][j+d[1]]>grid[i][j]+1)
            {
                grid[i+d[0]][j+d[1]]=grid[i][j]+1;
                que.add(new int[]{i+d[0],j+d[1]});  
            }
         }
     }
     return grid[grid.length-1][grid.length-1]==Integer.MAX_VALUE
                        ?-1:grid[grid.length-1][grid.length-1]+1;
    }

    boolean isValid(int i,int j,int[][] grid)
    {
        return !(i<0 || i==grid.length ||j<0 || j==grid.length);
    }
}