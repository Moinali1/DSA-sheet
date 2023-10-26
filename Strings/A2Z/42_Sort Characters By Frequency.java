class Solution {
    public String frequencySort(String s) {
       HashMap<Character,Integer> map= new HashMap<>();
        for(char ch:s.toCharArray())
                map.put(ch,map.getOrDefault(ch,0)+1);
       PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[1]-a[1]);      

       for(Map.Entry<Character,Integer> entry: map.entrySet())
       {
           pq.add(new int[]{entry.getKey(),entry.getValue()});
       } 

       StringBuilder sb= new StringBuilder(""); 
       while(!pq.isEmpty()) 
       {
           int[] top=pq.remove();
           int ch=top[0];
           int count=top[1];
           while(count>0)
           {
               sb.append((char)ch);
               count--;
           }
       }

    return sb.toString();
    }
}

// more better
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
						
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
				
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }
}