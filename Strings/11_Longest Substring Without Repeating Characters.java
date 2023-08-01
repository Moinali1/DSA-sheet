
class Solution
{
    

    int SubsequenceLength(String s) 
    {
        if(s.length()==0)return 0;
        HashMap<Character,Integer> map= new HashMap<>();
        int i=0,j=0,size=s.length(),ans=1;
        
        while(j<size)
        {
            char c=s.charAt(j);
            if(map.containsKey(c)){
                i=map.get(c)>=i?map.get(c)+1:i;
            }
           
            map.put(c,j);
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
    
}
