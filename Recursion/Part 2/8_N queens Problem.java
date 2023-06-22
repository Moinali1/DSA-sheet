class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();
        boolean matrix[][]= new boolean[n][n];
        getOrder(matrix,0,n,ans);
        return ans;
    }
    public void getOrder(boolean matrix[][],int r,int n,List<List<String>> ans)
    {
        if(r>=n)
        {
            ans.add(addAns(matrix,n));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isSafe(matrix,r,i,n))
            {
                matrix[r][i]=true;
                getOrder(matrix,r+1,n,ans);
                matrix[r][i]=false;
            }
        }
    }
    public boolean isSafe(boolean[][] matrix,int r,int c,int n)
    {
        int i=r,j=c;
        while(i>-1)
            if(matrix[i--][j])return false;
        
        i=r;
        while(i>-1 && j>-1)
            if(matrix[i--][j--])return false;
        
        i=r;j=c;
        while(i>-1 && j<n)
            if(matrix[i--][j++])return false;

        return true;
    }
    public List<String> addAns(boolean[][] matrix,int n)
    {
        List<String> ongoing= new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            String s="";
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j])s=s+"Q";
                else s=s+".";
            }
            ongoing.add(s);
        }
        return ongoing;
    }
}










