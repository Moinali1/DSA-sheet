class solution{
    void dfs(int[][] image, int i, int j,int val, int newColor)
    {
        if(i<0 || i>=image.size() || j<0 || j>= image[0].size() || image[i][j] == newColor || image[i][j] != val)
        {
            return;
        }
        image[i][j] = newColor;
        dfs(image,i-1,j,val,newColor);
        dfs(image,i+1,j,val,newColor);
        dfs(image,i,j-1,val,newColor);
        dfs(image,i,j+1,val,newColor);
    }
    
    int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int val = image[sr][sc];
        dfs(image,sr,sc,val,newColor);
        return image;
    }
}


class Solution {
    int[] dir={-1,+1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fillColor(sr,sc,color,image);
        return image;
    }
    void fillColor(int sr,int sc,int color,int[][] image)
    {
        if(image[sr][sc]==color)return;
        int curColor=image[sr][sc];
        image[sr][sc]=color;

        for(int i=0;i<=3;i++)
        {
            if(isVaild(sr+dir[i],sc+dir[3-i],image) && image[sr+dir[i]][sc+dir[3-i]]==curColor)
            {
                fillColor(sr+dir[i],sc+dir[3-i],color,image);
            }
        }
    }
    boolean isVaild(int sr,int sc,int[][] image)
    {
        return !(sr<0 ||sr==image.length || sc<0 ||sc==image[0].length);
    }
}

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         fillColor(sr,sc,color,image);
//         return image;
//     }
//     void fillColor(int sr,int sc,int color,int[][] image)
//     {
//         if(image[sr][sc]==color)return;
//         int curColor=image[sr][sc];
//         image[sr][sc]=color;
//         if(isVaild(sr-1,sc,image) && image[sr-1][sc]==curColor)
//         {
//             fillColor(sr-1,sc,color,image);
//         }
//         if(isVaild(sr+1,sc,image) && image[sr+1][sc]==curColor)
//         {
//             fillColor(sr+1,sc,color,image);
//         }
//         if(isVaild(sr,sc-1,image) && image[sr][sc-1]==curColor)
//         {
//             fillColor(sr,sc-1,color,image);
//         }
//         if(isVaild(sr,sc+1,image) && image[sr][sc+1]==curColor)
//         {
//             fillColor(sr,sc+1,color,image);
//         }
//     }
//     boolean isVaild(int sr,int sc,int[][] image)
//     {
//         return !(sr<0 ||sr==image.length || sc<0 ||sc==image[0].length);
//     }
// }