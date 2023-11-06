class Solution {
    public int[] findPeakGrid(int[][] mat) {
     int colstart=0;
     int colend=mat[0].length-1;
     int row=0;
       while(colstart<=colend){
          int maxrow=0;   
          int midcol=colstart+(colend-colstart)/2;
          for(row=0;row<mat.length;row++)
          {
              maxrow= mat[row][midcol]>=mat[maxrow][midcol] ? row:maxrow;
          }
         boolean checkright=colend>=midcol+1 && mat[maxrow][midcol]<mat[maxrow][midcol+1];
         boolean checkleft= colstart<=midcol-1 && mat[maxrow][midcol]<mat[maxrow][midcol-1];
         if(!checkright && !checkleft)
         {
             return new int[]{maxrow,midcol};
         }
         else if(checkright)
              colstart=midcol+1;
        else
            colend=midcol-1;
           
    }
    return null;
    }
}