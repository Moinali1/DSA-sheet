class GfG
{
	public int remAnagrams(String s1,String s2)
        {
        int count[]= new int[26];int ans=0;
        
        for(int i=0;i<s1.length();i++)count[s1.charAt(i)-'a']++;
        for(int i=0;i<s2.length();i++)count[s2.charAt(i)-'a']--;
        for(int i=0;i<26;i++)ans+=Math.abs(count[i]);
        return ans;
        }
}