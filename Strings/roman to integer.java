class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
    int i=1,ans=0;
      ans+=getNum(s.charAt(0));
      while(i<s.length())
      {
          if(getNum(s.charAt(i))<=getNum(s.charAt(i-1)))
          {
              ans+=getNum(s.charAt(i));
          }
          else
          {
              ans+=(getNum(s.charAt(i))-(2*getNum(s.charAt(i-1))));
          }
          i++;
      }
      return ans;
    }
    public int getNum(char A)
    {
        if(A=='I')return 1;
        else if(A=='V')return 5; 
        else if(A=='X')return 10; 
        else if(A=='L')return 50; 
        else if(A=='C')return 100; 
        else if(A=='D')return 500; 
        else return 1000; 
    }
}