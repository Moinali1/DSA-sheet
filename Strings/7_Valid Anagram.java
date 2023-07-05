class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length()!=t.length())return false;
      int[] letters= new int[26];
      Arrays.fill(letters,0);

      for(int i=0;i<s.length();i++) ++letters[s.charAt(i)-'a'];

      for(int i=0;i<t.length();i++)--letters[t.charAt(i)-'a'];

      for(int i:letters)if(i!=0)return false;
      return true;    
    }
}