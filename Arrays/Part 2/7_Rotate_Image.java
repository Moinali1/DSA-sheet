class Solution {
    public void rotate(int[][] mat) {
        int r=0,c=mat.length-1,size=mat.length-2;
        while(r<c)
        {
            for(int i=0;i<=size;i++)
            {
                swap(mat,r,r+i,r+i,c);
                swap(mat,r,r+i,c,c-i);
                swap(mat,r,r+i,c-i,r);
            }
           r++;c--;
           size-=2;//because both row and col are decreasing
        }
    }
    public void swap(int[][] mat,int r1,int c1,int r2,int c2)
    {
        int temp=mat[r1][c1];
        mat[r1][c1]=mat[r2][c2];
        mat[r2][c2]=temp;
    }
}


// https://leetcode.com/problems/rotate-image/description/