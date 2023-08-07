
class Solution {

    public boolean isValid(String s) {
     
        if(s.matches(".*[a-zA-Z].*"))return false;
        String[] ip= s.split("\\.",-1);
        
        if (ip.length!= 4) return false;
        for (String j : ip) {
            if (j.equals("")) return false;
            int subIp = Integer.parseInt(j);
            if (subIp != 0 && (int) Math.log10(subIp) + 1 != j.length()) return false;
            if (subIp == 0 && j.length() != 1) return false;
            if (subIp < 0 || subIp > 255) return false;
        }
        return true;
    }

}



// Another way by arraylist


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
    ArrayList<String> ip= new ArrayList<>();
    String cur="";
    int i=0;
    while(i<=s.length())
    {
        
            if(i==s.length() || s.charAt(i)=='.')
            {
                ip.add(cur);
                cur="";
            }
            else{
                if(s.charAt(i)-'0'<0 ||s.charAt(i)-'0'>9)return false;
                cur+=s.charAt(i)-'0';
            }
            i++;
       
    }
    
    if (ip.size() != 4) return false;
    for (String j : ip) {
        if (j.equals("")) return false;
        int subIp = Integer.parseInt(j);
        if (subIp != 0 && (int) Math.log10(subIp) + 1 != j.length()) return false;
        if (subIp == 0 && j.length() != 1) return false;
        if (subIp < 0 || subIp > 255) return false;
    }
    return true;
}

}