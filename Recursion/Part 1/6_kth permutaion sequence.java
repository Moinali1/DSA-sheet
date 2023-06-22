class Solution {
    public String getPermutation(int n, int k) {
     String ans="";
     int totalper=1;
     ArrayList<Integer> nums= new ArrayList<>();
     for(int i=1;i<=n;i++)
     {
         nums.add(i);
         totalper*=i;
     }
     k=k-1;//zero based indexing
     while(nums.size()!=1)
     {
         int setsize=totalper/nums.size();
         totalper/=nums.size();
         ans=ans+nums.remove(k/setsize);
         k=k%setsize;
     }
     ans=ans+nums.get(0);
     return ans;
    }
}