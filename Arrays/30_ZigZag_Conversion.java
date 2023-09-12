// class Solution {
//     public String convert(String s, int numRows) {
//         TreeMap<Integer,StringBuilder> map= new TreeMap<>();
//         for(int i=0;i<numRows;i++)map.put(i,new StringBuilder());
//         int idx=0;
//         while(idx<s.length())
//         {
//             for(int i=0;i<numRows && idx<s.length();i++)
//             {
//                  map.get(i).append(s.charAt(idx++));
//             }
//             for(int j=1;j<=numRows-2 && idx<s.length();j++)
//             {
//                 map.get(numRows-1-j).append(s.charAt(idx++));
//             }
//         }
//         String ans="";
//         for(StringBuilder sb: map.values())
//         {
//             ans+=sb.toString();
//         }
//         return ans;
//     }
// }
class Solution{
public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
    
    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}
}