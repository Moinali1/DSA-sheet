class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans= new ArrayList<>();
        getPath(0,0,"",m,ans,n);
        return ans;
    }
    public static void getPath(int r,int c, String s,int[][] m,ArrayList<String> ans,int n)
    {
        if(r<0 || r>=n ||c<0 ||c>=n)return;
        if(m[r][c]==0)return;
        if(r==n-1 && c==n-1)
        {
            ans.add(s);
            return;
        }
            
            m[r][c]=0;
            getPath(r+1,c,s+"D",m,ans,n);    
      
      
            getPath(r,c+1,s+"R",m,ans,n);    
    
            getPath(r-1,c,s+"U",m,ans,n);    
    
            getPath(r,c-1,s+"L",m,ans,n);    
            m[r][c]=1;
        
    }
}