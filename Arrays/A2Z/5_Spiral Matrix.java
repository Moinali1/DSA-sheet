class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        ArrayList<Integer> mylist= new ArrayList<Integer>();
        int rowend= arr.length-1;
        int colend=arr[0].length-1;
        int rowstart=0;
        int colstart=0;
        while(rowstart<=rowend && colstart<=colend)
        {
            for(int i=colstart;i<=colend;i++)
            {
                mylist.add(arr[rowstart][i]);
            }
             rowstart++;
            for(int i=rowstart;i<=rowend;i++){
             mylist.add(arr[i][colend]);
             }
             colend--;
             if(rowstart<=rowend){
             for(int i=colend;i>=colstart;i--)
             {
                  mylist.add(arr[rowend][i]);
             }}
             rowend--;
             if(colstart<=colend){
              for(int i=rowend;i>=rowstart;i--)
             {
                  mylist.add(arr[i][colstart]);
             }}
             colstart++;
          }
        return mylist;
}}