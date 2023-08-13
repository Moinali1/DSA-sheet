
class Solution {
    public List<List<String>> Anagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();
        
        int chars[]=new int[27];
        
        for(String s:strs)
        {
            for(char c: s.toCharArray()) chars[c-'a'+1]++;
            String key="";
            for(int i=0;i<27;i++)
                if(chars[i]!=0)
                {
                    key+=(chars[i]+"#"+i+"##");
                    chars[i]=0;
                }
            
            if(!map.containsKey(key))    
            {
                map.put(key,new ArrayList<>(Arrays.asList(s)));
            }
            else{
                map.get(key).add(s);
            }
        }
        
        List<List<String>> ans= new ArrayList<>();
        for(List<String> i:map.values())ans.add(i);
        
        return ans;
    }
}
