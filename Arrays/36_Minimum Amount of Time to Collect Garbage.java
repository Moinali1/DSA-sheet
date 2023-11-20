 class Solution
 {
     public int garbageCollection(String[] garbage, int[] travel) {
        int last[] = new int[128], res = 0;
        for (int i = 0; i < garbage.length; ++i) {
            res += garbage[i].length();
            for (int j = 0; j < garbage[i].length(); ++j)
                last[garbage[i].charAt(j)] = i;
        }
        for (int j = 1; j < travel.length; ++j)
            travel[j] += travel[j - 1];
        for (int c : "PGM".toCharArray())
            if (last[c] > 0)
                res += travel[last[c] - 1];
        return res;
    }
 }



class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        HashMap<Integer,HashMap<Character,Integer>> map= new HashMap<>();

        for(int i=0;i<garbage.length;i++)
        {
            map.put(i,new HashMap<>());
            for(char ch:garbage[i].toCharArray())
            {
                map.get(i).put(ch,map.get(i).getOrDefault(ch,0)+1);
            }            
        }

       return traverse(map,travel,'G') +traverse(map,travel,'P')+traverse(map,travel,'M');  
    }
    public int traverse(HashMap<Integer,HashMap<Character,Integer>> map,int[] travel,char type)
    {
        int res=0,cur=0;
        for(int i=0;i<map.size();i++)
        {
            Integer count=map.get(i).get(type);
            if(count!=null)
            {
                res+=cur;
                res+=(int)count;
                cur=0;
            }
            cur+=i!=map.size()-1?travel[i]:0;
        }
        return res;
    }
}
