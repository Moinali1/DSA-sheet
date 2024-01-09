class Solution {
    public boolean isPalindrome(String s) {
    s=s.toLowerCase();
    StringBuilder sb =new StringBuilder("");    
    for(char i:s.toCharArray())
    {
        if(Character.isLetter(i)||Character.isDigit(i))
        sb.append(i);
    }
    int i=0,j=sb.length()-1;
    while(i<j)
    {
        if(sb.charAt(i++)!=sb.charAt(j--))return false;
    }   
    return true; 

    }
}