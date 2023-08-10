class Solution
{

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
            
        StringBuilder ans=new StringBuilder("");
        int[] cur=pq.remove();
        int[] temp=!pq.isEmpty()?pq.remove():new int[]{-1,0};
        
        while(cur[1]!=0)
        {
            if(temp[1]==0 && cur[1]>1)return "";
            ans.append((char)(cur[0]+'a'));
            cur[1]--;
            if(cur[1]>0)pq.add(cur);
            cur=temp;
            temp=!pq.isEmpty()?pq.remove():new int []{-1,0};
        }
        
        return ans.toString(); 
   }
   
}