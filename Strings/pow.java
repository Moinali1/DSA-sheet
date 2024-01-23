class Solution {
    public double myPow(double x, int n) {
        return n>0?pow(x,n):1/pow(x,n);
    }
    public double pow(double x,int n)
    {
        if(n==0)return 1;
        double i=pow(x,n/2);
        double ans= i*i;
        if(n%2!=0)ans=ans*x;
        return ans; 
    }
}

// https://leetcode.com/problems/powx-n/description/