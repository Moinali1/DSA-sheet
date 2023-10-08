class Solution {
     static class Disjoint{
        int V;
        int[] rank;
        int[] parent;
        
        Disjoint(int V)
        {
            this.V=V;
            rank= new int[V];parent= new int[V];
            for(int i=0;i<V;i++)
                parent[i]=i;
        }
        
        int findPrnt(int node)
        {
            if(node==parent[node])return node;
            return parent[node]=findPrnt(parent[node]);
        }
        
        void unionByRank(int u,int v)
        {
            int uni_U=findPrnt(u),uni_V=findPrnt(v);
            int uRank=rank[uni_U],vRank=rank[uni_V];
            if(uni_U==uni_V)return;
            if(uRank>vRank) parent[uni_V]=uni_U;
            else if(vRank>uRank)parent[uni_U]=uni_V;
            else{
                parent[uni_V]=uni_U;
                rank[uni_U]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> acc) {
        Disjoint ds= new Disjoint(acc.size());
        HashMap<String,Integer> map= new HashMap<>();// space (N)

        for(int i=0;i<acc.size();i++) // time N+M no. of elements
        {
            for(int j=1;j<acc.get(i).size();j++)
            {
                String key=acc.get(i).get(j);
                if(map.containsKey(key))
                    ds.unionByRank(map.get(key),i);
                else map.put(key,i);                       
            }
        }
        
        for(int i=0;i<ds.parent.length;i++)ds.findPrnt(i); // N

        List<List<String>> ans= new ArrayList<>();
        for(int i=0;i<acc.size();i++) ans.add(new ArrayList<>()); // N

        for(Map.Entry<String,Integer> entry:map.entrySet()) // N
        {
            String key=entry.getKey();int value=entry.getValue();
            
            int valPrnt=ds.findPrnt(value);
            if(ans.get(valPrnt).size()==0) 
                ans.get(valPrnt).add(acc.get(valPrnt).get(0));
            ans.get(valPrnt).add(key);     
        }

        for(int i=ans.size()-1;i>=0;i--) // N+ (N*MlogM) +N
        {
            if(ans.get(i).size()<=1)ans.remove(i);
            else 
            {
                String name=ans.get(i).get(0);
                ans.get(i).remove(0);
                Collections.sort(ans.get(i));
                ans.get(i).add(0,name);

            }
        }
        return ans;   
    }
}

















