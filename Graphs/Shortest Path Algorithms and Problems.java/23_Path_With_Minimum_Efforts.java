
class Solution {
    
    int MinimumEffort(int heights[][]) {
     int[][] minEff=new int[heights.length][heights[0].length];
        for(int row[]:minEff)Arrays.fill(row,Integer.MAX_VALUE-1);
        minEff[0][0]=0;

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});

        int[][] dirs={{-1,0},{0,+1},{1,0},{0,-1}};

        while(!pq.isEmpty())
        {
            int[] cur=pq.remove();
            int curmin=cur[0],row=cur[1],col=cur[2];

            for(int d[]:dirs)
            {
                if(isValid(row+d[0],col+d[1],heights))
                {
                    int diff= Math.abs(heights[row+d[0]][col+d[1]]-heights[row][col]);
                    diff=curmin<diff?diff:curmin;
                    if(minEff[row+d[0]][col+d[1]]>diff)
                    {
                        minEff[row+d[0]][col+d[1]]=diff;
                        pq.add(new int[]{diff,row+d[0],col+d[1]});
                    } 
                }
            }
        }
        return minEff[heights.length-1][heights[0].length-1];

    }
    boolean isValid(int row,int col,int[][] heights)
    {
        return !(row<0 || row==heights.length ||col<0 ||col==heights[0].length);
    }
}

