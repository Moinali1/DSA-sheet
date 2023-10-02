import java.util.*;

public class Solution {
    public static List< Integer > countPrimes(int n) {
        List<Integer> ans= new ArrayList<>();
        for(int i=2;i<=n/2;i++)
        {
            if(isPrime(i)&& n%i==0)ans.add(i);
        }
        return ans;
    }
   static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)return false;
        }
        return true;
    }
}

// https://www.codingninjas.com/studio/problems/prime-factorisation_1760849?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
