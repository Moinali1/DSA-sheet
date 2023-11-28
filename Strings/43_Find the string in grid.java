class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        ArrayList<int[]> ans= new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(word.charAt(0)==grid[i][j])
                {
                boolean res=search(i,j,"D",word,ans,grid) || search(i,j,"U",word,ans,grid) ||
                            search(i,j,"R",word,ans,grid )|| search(i,j,"L",word,ans,grid)  ||
                            search(i,j,"UR",word,ans,grid)|| search(i,j,"UL",word,ans,grid) ||
                            search(i,j,"DR",word,ans,grid)|| search(i,j,"DL",word,ans,grid) ;
                if(res) ans.add(new int[]{i,j});
                }
            }
        }
        return ans.toArray(new int[ans.size()][]); 
    }
    public boolean search(int r,int c,String dir,String word,ArrayList<int[]> ans,char[][] grid)
    {
    if(word.isEmpty())
    {
        return true;
    }
    if(isVaild(r,c,grid) && word.charAt(0)==grid[r][c])
    {
    if(dir=="D")
    {
       return search(r+1,c,"D",word.substring(1),ans,grid);   
    }
    else if(dir=="U")
    { 
       return search(r-1,c,"U",word.substring(1),ans,grid);   
    }
    else if(dir=="R")
    {
        return search(r,c+1,"R",word.substring(1),ans,grid);   
    }
    else if(dir=="L")
    {
        return search(r,c-1,"L",word.substring(1),ans,grid);   
    }
    else if(dir=="UR")
    {
        return search(r-1,c+1,"UR",word.substring(1),ans,grid);   
    }
    else if(dir=="UL")
    {
        return search(r-1,c-1,"UL",word.substring(1),ans,grid);   
    }
    else if(dir=="DR")
    {
        return search(r+1,c+1,"DR",word.substring(1),ans,grid);   
    }
    else 
    {
        return search(r+1,c-1,"DL",word.substring(1),ans,grid);   
    }
    }
    return false;
    
}

    public boolean isVaild(int r,int c,char[][] grid)
    {
        return r>-1 && c>-1 && r<grid.length && c<grid[0].length;
    }
    
}




