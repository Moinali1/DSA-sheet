class Solution {
    public int orangesRotting(int[][] grid) {
       Queue<int[]> que= new LinkedList<>();
       int countfresh=0;
       for(int i=0;i<grid.length;i++)
       {
           for(int j=0;j<grid[0].length;j++)
           {
               if(grid[i][j]==2){
                   grid[i][j]=0;
                   que.add(new int[]{i,j,0});
               }
               else if(grid[i][j]==1)
               {grid[i][j]=Integer.MAX_VALUE;
                countfresh++;
               }
           }
       }
       return rotOrange(grid,que,countfresh);
    }
    public int rotOrange(int[][] grid, Queue<int[]> que,int countfresh)
    {
        int time=0;
        while(!que.isEmpty())
        {
            int[] p=que.remove();
            int r=p[0];int c=p[1];int curtime=p[2];
            if(isValid(grid,r-1,c) && grid[r-1][c]>grid[r][c]+1)
            {
                grid[r-1][c]=grid[r][c]+1;
                que.add(new int[]{r-1,c,curtime+1});
                countfresh--;
            }

            if(isValid(grid,r+1,c) && grid[r+1][c]>grid[r][c]+1)
            {
                grid[r+1][c]=grid[r][c]+1;
                que.add(new int[]{r+1,c,curtime+1});
                countfresh--;
            }

            if(isValid(grid,r,c+1) && grid[r][c+1]>grid[r][c]+1)
            {
                grid[r][c+1]=grid[r][c]+1;
                que.add(new int[]{r,c+1,curtime+1});
                countfresh--;
            } 
    
            if(isValid(grid,r,c-1) && grid[r][c-1]>grid[r][c]+1)
            {
                grid[r][c-1]=grid[r][c]+1;        
                que.add(new int[]{r,c-1,curtime+1});
                countfresh--;
            }
            time=Math.max(time,curtime);
        }

       return countfresh!=0?-1:time;
    }
    public boolean isValid(int grid[][],int r,int c)
    {
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length;
    }
}












