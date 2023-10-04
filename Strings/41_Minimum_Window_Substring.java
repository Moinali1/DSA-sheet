import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        int tCount = t.length();
        int ansLen = s.length() + 1;
        int ansi = 0, ansj = 0;

        int i = 0, j = 0;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    tCount--;
                }
            }
            j++;

            while (tCount == 0) {
                if (ansLen > j - i) {
                    ansi = i;
                    ansj = j;
                    ansLen = j - i;
                }

                char ch2 = s.charAt(i);
                if (map.containsKey(ch2)) {
                    map.put(ch2, map.get(ch2) + 1);
                    if (map.get(ch2) > 0) {
                        tCount++;
                    }
                }
                i++;
            }
        }
        
        return ansLen == s.length() + 1 ? "" : s.substring(ansi, ansj);
    }
}
