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




// we can do like this also
class Soluton {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        ArrayList<String> list=new ArrayList<>();
        helper(S,ans,list);
        return ans;
    }
    public static void helper(String S,ArrayList<ArrayList<String>>ans,ArrayList<String> ongoing)
    {
        if(S.isEmpty())
        {
            ans.add(new ArrayList<>(ongoing));
            return;
        }
        
        for(int i=1;i<=S.length();i++)
        {
            String cur=S.substring(0,i);
            if(pail(cur))
            {
                ongoing.add(cur);
                helper(S.substring(i),ans,ongoing);
                ongoing.remove(ongoing.size()-1);
            }
        }
    }
    public static boolean pail(String s)
    {
        int st=0;
        int e=s.length()-1;
        while(st<e)
        {
           if(s.charAt(st)!=s.charAt(e))
           return false;
           st++;
           e--;
        }
        return true;
    }
};