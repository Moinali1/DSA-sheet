class Solution
{
    public ArrayList<String> permutation(String s)
    {
     ArrayList<String> ans= new ArrayList<>();
     getPermutation("",s,ans);
     Collections.sort(ans);
     return ans;
    }
    
    ArrayList<String> getPermutation(String pro,String unpro,ArrayList<String> ans)
    {
        if(unpro.isEmpty())
        {
            ans.add(pro);
            return ans;
        }
        
        char newch=unpro.charAt(0);
        for(int i=0;i<=pro.length();i++)
        {
            String ongoing= pro.substring(0,i)+newch+pro.substring(i,pro.length());
            getPermutation(ongoing,unpro.substring(1,unpro.length()),ans);
        }
        return ans;
    }
	   
}
