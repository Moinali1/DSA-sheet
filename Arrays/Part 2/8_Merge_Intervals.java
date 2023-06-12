import java.util.*;
class Solution {
    public int[][] merge(int[][] in) {
    Arrays.sort(in,(a,b)->(a[0]-b[0]));
    int s=in[0][0],e=in[0][1];
    ArrayList<int[]> ans= new ArrayList<>();
    for(int i=1;i<in.length;i++)
    {
        if(in[i][0]>e)
        {
            ans.add(new int[]{s,e});
            s=in[i][0];e=in[i][1];
        }
        else e=Math.max(e,in[i][1]);
    }
    ans.add(new int[]{s,e});
    return ans.toArray(new int[ans.size()][]);
    }
}

//  int convans[][]= new int[ans.size()][];
//     for(int i=0;i<ans.size();i++)
//     {
//         convans[i]=ans.get(i);
//     }
//     return convans;

// https://leetcode.com/problems/merge-intervals/description/