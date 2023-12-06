class Solution{
    static String lookandsay(int n) {
        if(n==1)return "1";
        String say=lookandsay(n-1);
        StringBuilder res=new StringBuilder("");
        for(int i=0;i<say.length();i++)
        {
            int count=1;
            while(i<say.length()-1 && say.charAt(i)==say.charAt(i+1))
            {
                count++;
                i++;
            }
            res.append(count).append(say.charAt(i));
        }
        return res.toString();
    }
}
