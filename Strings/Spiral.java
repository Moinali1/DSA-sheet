// new code
// class Solution {
//     public int[][] generateMatrix(int n) {
//         int[][] matrix= new int[n][n];
//         int rowend=n-1;
//         int colend=n-1;
//         int rowstart=0;
//         int colstart=0;    
//         int count=1;
//         while(rowstart<=rowend && colstart<=colend)  
//         {
//             for(int i=colstart;i<=colend;i++)
//             {
//                 matrix[rowstart][i]=count;
//                 count++;
//             }
//             rowstart++;
//             for(int i=rowstart;i<=rowend;i++)
//             {
//                 matrix[i][colend]=count;
//                 count++;}
//             colend--;
//             for(int i=colend;i>=colstart;i--)
//             {
//                 matrix[rowend][i]=count;
//             count++;}
//             rowend--;
//             for(int i=rowend;i>=rowstart;i--)
//             {
//             matrix[i][colstart]=count;
//             count++;
//             }
//             colstart++;
     
//         }
//         return matrix;
        
//     }
// }