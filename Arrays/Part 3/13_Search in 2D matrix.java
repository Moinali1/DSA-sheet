class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    int r=matrix.length,c=matrix[0].length;
    int s=0,e=r*c-1;
    while(s<=e)
    {
        int mid=s+(e-s)/2;
        if(matrix[mid/c][mid%c]==target)return true; 
        else if(matrix[mid/c][mid%c]>target)e=mid-1;
        else s=mid+1;
    }     
    return false;

    }
}

// https://leetcode.com/problems/search-a-2d-matrix/description/