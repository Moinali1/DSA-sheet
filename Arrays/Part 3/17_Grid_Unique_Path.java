class Solution {
    int count=0;
    public int uniquePaths(int A, int B) {
        int mat[][]=new int[A][B];
        for(int i=0;i<A;i++)
            for(int j=0;j<B;j++)
            {
                if(i==0 ||j==0)mat[i][j]=1;
                else mat[i][j]=mat[i-1][j]+mat[i][j-1];
            }
        return mat[A-1][B-1];
    }
}

//  int mat[][]=new int[A][B];
//         int m=A,n=B;
//         for(int r=0;r<m;r++) mat[r][n-1]=1;
//         for(int c=0;c<n;c++) mat[m-1][c]=1;
//         for(int i=m-2;i>=0;i--)
//             for(int j=n-2;j>=0;j--)
//             {
//                 mat[i][j]=mat[i+1][j]+mat[i][j+1];
//             }
//         return mat[0][0];


class Solutin {
    public int uniquePaths(int m, int n) {
     int r=m-1,d=n-1;
     int total=r+d;
     double com1=1,com2=1;
     for(int i=1;i<=r;i++)
     {
         com1=com1*(total-r+i)/i;
     }
     for(int i=1;i<=d;i++)
     {
         com2=com2*(total-d+i)/i; 
     }
     return (int)Math.max(com1,com2);

    }
}

// https://leetcode.com/problems/unique-paths/description/