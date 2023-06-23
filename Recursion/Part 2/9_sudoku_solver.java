class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public boolean solve(char[][] board,int i,int j)
    {
        if(i>=9)return true;
        if(j>=9)return solve(board,i+1,0);

                if(board[i][j]=='.')
                {
                    for(int k=1;k<=9;k++)
                    {
                        char num=(char)(k+'0');
                        if(isSafe(board,i,j,num))
                        {
                            board[i][j]=num;
                            boolean ans=solve(board,i,j+1);
                            if(ans)return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
        return solve(board,i,j+1);        
        }
    public boolean isSafe(char[][] board,int r,int c,char num)
    {
        int i,j;
        for(i=0;i<9;i++)
        {
            if(board[r][i]==num)return false;
            if(board[i][c]==num)return false;
        }
        
        i=r-r%3;j=c-c%3;
        for(int x=i;x<i+3;x++)
            for(int y=j;y<j+3;y++)
                if(board[x][y]==num)return false;
            
        return true;
    }
}