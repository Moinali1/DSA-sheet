
class Solution {
    public ArrayList<String> genIp(String s) {
       if(s.length()<4)return new ArrayList<>();
       
       ArrayList<String> ans= new ArrayList<>();
       getIP("",s,0,3,ans);
       return ans;
    }
    void getIP(String pro,String s,int idx,int point,ArrayList<String> ans)
    {
        if(s.length()-idx<=point)return;
        if(point==0)
        {
            String subIP=s.substring(idx,s.length());
            long intSubIP=Long.parseLong(subIP);
            if(intSubIP!=0 && (int)Math.log10(intSubIP)+1!=subIP.length())return;
            if(intSubIP==0 && subIP.length()!=1)return;
            if(intSubIP>=0 && intSubIP<=255)ans.add(pro+subIP);
            return;
        }
        
        for(int i=idx+1;i<s.length();i++)
        {
            String subIP=s.substring(idx,i);
            long intSubIP=Long.parseLong(subIP);
            if(intSubIP!=0 && (int)Math.log10(intSubIP)+1!=subIP.length())break;
            if(intSubIP==0 && subIP.length()!=1)break;
            if(intSubIP<0 || intSubIP>255)break;

            getIP(pro+subIP+".",s,i,point-1,ans);
        }
    }
}