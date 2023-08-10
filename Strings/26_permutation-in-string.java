public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }
        
        return false;
    }
    
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}





// another approch
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int chars[]= new int[26];
        HashMap<Character,Integer> map= new HashMap<>();
        int charCount=s1.length();
        for(int i=0;i<s1.length();i++)
        {
            chars[s1.charAt(i)-'a']++;
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }

        int i=0,j=0;
        while(j<s2.length() && charCount!=0)
        {
            char cAtj=s2.charAt(j);
            
            if(map.containsKey(cAtj))
            {
                if(map.get(cAtj)==0)charCount+=chars[cAtj-'a'];
                map.put(cAtj,map.get(cAtj)-1);
                if(map.get(cAtj)==0)charCount-=chars[cAtj-'a'];
            }
            if(j>=s1.length()){
                char cAti=s2.charAt(i);
                if(map.containsKey(cAti))
                {
                    if(map.get(cAti)==0)charCount+=chars[cAti-'a'];
                    map.put(cAti,map.get(cAti)+1);
                    if(map.get(cAti)==0)charCount-=chars[cAti-'a'];
                }  
                i++;
            }
            j++;
        }

        return charCount==0?true:false;
    }
}