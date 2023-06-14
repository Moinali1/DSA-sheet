import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
      int i=0,j=0;
      int ans=0,cur=0;
      HashMap<Character,Integer> map=new HashMap<>();

      for(j=0;j<s.length();j++)
      {
          if(map.containsKey(s.charAt(j)))
          {
            i=Math.max(i,map.get(s.charAt(j))+1); 
            map.put(s.charAt(j),j);
          }
          else{
              map.put(s.charAt(j),j);
          }
          ans=Math.max(ans,j-i+1);
      }  
    return ans;
    }
}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//       int i=0,j=0;
//       int ans=0,cur=0;
//       HashMap<Character,Integer> map=new HashMap<>();

//       for(j=0;j<s.length();j++)
//       {
//           if(map.containsKey(s.charAt(j)))
//           {
//             int idx=map.get(s.charAt(j))+1; 
//             while(i!=idx)
//             {
//                 map.remove(s.charAt(i));
//                 i++;
//             }  
//             map.put(s.charAt(j),j);
//           }
//           else{
//               map.put(s.charAt(j),j);
//           }
//           ans=Math.max(ans,j-i+1);
//       }  
//     return ans;
//     }
// }
