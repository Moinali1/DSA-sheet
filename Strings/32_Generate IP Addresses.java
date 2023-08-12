//recursion

class Solution {
    public List<String> restoreIpAddresses(String s) {
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
            
            if(subIP.charAt(0)=='0' && subIP.length()>1)return;
            
            if(intSubIP>=0 && intSubIP<=255)ans.add(pro+subIP);
            return;
        }
        
        for(int i=idx+1;i<s.length();i++)
        {
            String subIP=s.substring(idx,i);
            long intSubIP=Long.parseLong(subIP);
            
            if(subIP.charAt(0)=='0' && subIP.length()>1)return;
            if(intSubIP<0 || intSubIP>255)return;

            getIP(pro+subIP+".",s,i,point-1,ans);
        }
    }
}




//Iteration


public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}