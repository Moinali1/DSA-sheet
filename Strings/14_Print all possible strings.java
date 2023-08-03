class GfG
{
    ArrayList<String> spaceString(String str)
    {
        ArrayList<String> ans= new ArrayList<>();
        ans= new ArrayList(getSets(str,ans,1,str.length()));
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
    }
    ArrayList<String> getSets(String s,ArrayList<String> ans,int idx,int n)
    {
        if(idx>=n){
            ans.add(s);
            return ans;
        }
        ans.add(s);
        for(int i=idx;i<n;i++)
        {
            String newS=s.substring(0,i)+" "+s.substring(i,n);
            getSets(newS,ans,i+2,n+1);
        }
        return ans;
    }
}