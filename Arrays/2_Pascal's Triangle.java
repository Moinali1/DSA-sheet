class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans=new ArrayList<>(); 

    for(int x=0;x<n;x++)
    {
        List<Integer> list= new ArrayList();
        int j=0;
        while(j<=x)
        {
            if(j==0 || j==x)list.add(1);
            else list.add(ans.get(x-1).get(j-1)+ans.get(x-1).get(j));
            j++;
        }
        ans.add(list);
    }    
    return ans;
    }
}