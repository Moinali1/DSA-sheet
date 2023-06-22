class Solution {
    public List<List<String>> partition(String s) {
    List<List<String>> ans= new ArrayList<>();
    List<String> ongoing= new ArrayList<>();

    getPartitions(s,0,ongoing,ans,s.length());
    return ans; 
    }
    public void  getPartitions(String s,int idx,List<String> ongoing,List<List<String>> ans,int sLen){
        if(idx==sLen)
        {
            ans.add(new ArrayList(ongoing));
            return;
        }
        for(int i=idx+1;i<=sLen;i++)
        {
            String subs=s.substring(idx,i);
            if(isPalin(subs))
            {
                ongoing.add(subs);
                getPartitions(s,i,ongoing,ans,sLen);
                ongoing.remove(ongoing.size()-1);
            }
        }
        
    }
    public boolean isPalin(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j) 
            if(s.charAt(i++)!=s.charAt(j--))return false;
        return true;
    }
}