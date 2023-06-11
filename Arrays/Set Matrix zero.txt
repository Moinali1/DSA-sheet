class Solution {
    public void setZeroes(int[][] matrix) {
        boolean is0RowZero=false;
        boolean is0ColZero=false;

        for(int i=0;i<matrix.length;i++)
        {
            for(int k=0;k<matrix[0].length;k++)
            {
                if(matrix[i][k]==0)
                {
                    if(i==0)is0RowZero=true;
                    if(k==0)is0ColZero=true;
                    matrix[i][0]=0;
                    matrix[0][k]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[0][j]==0 || matrix[i][0]==0) matrix[i][j]=0;
            }
        }
        if(is0RowZero)
            for(int i=0;i<matrix[0].length;i++) matrix[0][i]=0;
        if(is0ColZero)    
            for(int j=0;j<matrix.length;j++) matrix[j][0]=0;
    }
}

//  public void setZeroes(int[][] matrix) {
//         HashSet<Integer> rowIdx=new HashSet<>();
//         HashSet<Integer> colIdx=new HashSet<>();

//         for(int i=0;i<matrix.length;i++)
//         {
//             for(int k=0;k<matrix[0].length;k++)
//             {
//                 if(matrix[i][k]==0)
//                 {
//                     rowIdx.add(i);
//                     colIdx.add(k);
//                 }
//             }
//         }
//         for(int i:rowIdx)
//         {
//             for(int c=0;c<matrix[0].length;c++)
//             {
//                 matrix[i][c]=0;
//             }
//         }
//         for(int i:colIdx)
//         {
//             for(int r=0;r<matrix.length;r++)
//             {
//                 matrix[r][i]=0;
//             }
//         }
//     }