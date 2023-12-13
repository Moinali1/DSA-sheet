class Solution {
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