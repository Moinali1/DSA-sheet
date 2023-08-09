class Solution
{
    
   
   public static String rearrangeString(String str)
   {
       PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);
       int[] count= new int[26];
       for(int i=0;i<str.length();i++)count[str.charAt(i)-'a']++;
       
       for(int i=0;i<26;i++)
       {
           if(count[i]!=0)pq.add(new int[]{i,count[i]});
       }
            
        String ans="";
        int[] p1=pq.remove();
        int[] p2=pq.remove();
        
        while(pq.isEmpty())
        {
            if(p1[1]==0)p1=pq.remove();
                ans+=""+(char)(p1[0]+'a');
                p1[1]--;
            if(p2[1]==0)p2=pq.remove();
                ans+=""+(char)(p2[0]+'a');
                p2[1]--;
        }
        return ans;
   }
   
}

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;

public class Main
{
	public static void main(String[] args) {
		System.out.println(rearrangeString("ceecaca"));
	}
	public static String rearrangeString(String str)
   {
      int k=1;
        for(k=1;k<str.length();)
        {    
            if(str.charAt(k)==str.charAt(k-1))break;
            k++;
        }
        if(k==str.length())return str;
       PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);
       int[] count= new int[26];
       for(int i=0;i<str.length();i++)count[str.charAt(i)-'a']++;
       
       for(int i=0;i<26;i++)
       {
           if(count[i]!=0)pq.add(new int[]{i,count[i]});
       }
            
        String ans="";
        int[] p1=pq.remove();
        int[] p2=!pq.isEmpty()?pq.remove():new int[]{-1,0};
        
        while(!pq.isEmpty() || p1[1]!=0 || p2[1]!=0)
        {
            
            if(p1[1]!=0)
            {
                ans+=(char)(p1[0]+'a');
                p1[1]--;
                if(!pq.isEmpty() && p1[1]==0)p1=pq.remove();
            }
            if(!pq.isEmpty() && p2[1]==0)p2=pq.remove();
            if(p2[1]!=0)
            {
                ans+=(char)(p2[0]+'a');
                p2[1]--;
            }
        }
        if(p1[1]!=0)ans+=""+(char)(p1[0]+'a');
        if(p2[1]!=0)ans+=""+(char)(p2[0]+'a');
        
        // for(int i=1;i<ans.length();i++)
        //     if(ans.charAt(i)==ans.charAt(i-1))return "";
        return ans; 
       
   }
}
