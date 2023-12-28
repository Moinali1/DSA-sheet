class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<String> ongoing= getCodes(n);
        ArrayList<Integer> ans= new ArrayList<>();
        for(String i: ongoing) ans.add(Integer.parseInt(i,2));
        return ans;
    }
    ArrayList<String> getCodes(int n)
    {
        if(n==1)
        {
            return new ArrayList(Arrays.asList("0","1"));
        }
        ArrayList<String> prelist= getCodes(n-1);
        ArrayList<String> sublist= new ArrayList<>();
        
        for(int i=0;i<prelist.size();i++)
        {
            sublist.add("0"+prelist.get(i));
        }
        for(int j=prelist.size()-1;j>=0;j--)
        {
            sublist.add("1"+prelist.get(j));
        }
        return sublist;
    }
}