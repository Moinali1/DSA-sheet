
class Solution
{
    ArrayList<Integer> removeDuplicate(int arr[], int n)
    {
      HashSet<Integer> set= new HashSet<>();
      ArrayList<Integer> ans=new ArrayList();  
      
      for(int i:arr)
        if(!set.contains(i))
        {
            set.add(i);
            ans.add(i);
        }
    
      return ans;        
    }
}
