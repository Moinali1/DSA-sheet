//solution 1 reverse half of string
public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}


//solution 2
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x==0)return true;
        int y=x;
        int len=(int)Math.log10(x)+1;

        for(int i=0;i<len/2;i++)
        {
            int num1=(int)((int)x/Math.pow(10,len-1-i))%10;
            int num2=(int)y%10;
            y/=10;
            if(num1!=num2)return false;
        }
        return true;
    }
}