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