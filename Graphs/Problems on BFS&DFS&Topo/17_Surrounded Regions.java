class Solution {
    int dirs[][]={{-1,0},{0,-1},{1,0},{0,+1}};
    public void solve(char[][] board) {
        if(board.length<=2 || board[0].length<=2)return;
        
        for(int i=0;i<board.length;i++)
        {
            if(board[i][0]=='O')flipOtoStar(i,0,board);
            if(board[i][board[0].length-1]=='O')flipOtoStar(i,board[0].length-1,board);
        }
        for(int j=0;j<board[0].length;j++)
        {
            if(board[0][j]=='O')flipOtoStar(0,j,board);
            if(board[board.length-1][j]=='O')flipOtoStar(board.length-1,j,board);
        }

        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='*')board[i][j]='O';
            }
        }

    }
    public void flipOtoStar(int row,int col,char[][] board)
    {
        if(row<0 || row>=board.length ||col<0 ||col>=board[0].length)return;
        if(board[row][col]=='X' || board[row][col]=='*')return;

        board[row][col]='*';

        for(int d[]:dirs)
        {
            flipOtoStar(row+d[0],col+d[1],board);
        }
    }
}