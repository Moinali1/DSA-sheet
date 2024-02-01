class Solution {
    public String convertToTitle(int cn) {
        StringBuilder sb= new StringBuilder("");
        while(cn>26)
        {
            cn--;
            sb.insert(0,(char)('A'+cn%26));
            cn=cn/26;
        }
        cn--;
        sb.insert(0,(char)('A'+cn));
        return sb.toString();
    }
}