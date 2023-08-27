class Solution {
    public String removeDuplicateLetters(String s) {
       int alpCnt[]=new int[26];
       boolean alpTaken[]=new boolean[26];
       
       int ansLen=0; 
       for(int i=0;i<s.length();i++) alpCnt[s.charAt(i)-'a']++;
       for(int i=0;i<26;i++) if(alpCnt[i]!=0)ansLen++;

       char ans[]= new char[ansLen]; //we can use stack also

       int i=0,j=0; 
       while(i<s.length())
       {
           char cur=s.charAt(i++);
           alpCnt[cur-'a']--;
           if(j==0){
               ans[j++]=(char)cur;
               alpTaken[cur-'a']=true;
           }
           else{
               if(alpTaken[cur-'a'])continue;
               while(j!=0 && cur<ans[j-1] && alpCnt[ans[j-1]-'a']>0)
               {
                   alpTaken[ans[j-1]-'a']=false;
                   ans[--j]=(char)'0';
               }
               ans[j++]=(char)cur;
               alpTaken[cur-'a']=true;
           }
       }
       return new String(ans);
    }
}