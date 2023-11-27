class Solution
{
    int ans=0;
    public int sumK(Node root,int k)
    {
        ArrayList<Integer> ongoing =new ArrayList<>();
        helper(root,k,ongoing);
        return ans;
    }
    public void helper(Node root,int k,ArrayList<Integer> ongoing)
    {
        if(root==null)return;
        ongoing.add(root.data);
        int sum=0;
        for(int i=ongoing.size()-1;i>=0;i--)
        {
            sum+=ongoing.get(i);
            if(sum==k)ans++;
        }
        helper(root.left,k,ongoing);
        helper(root.right,k,ongoing);
        ongoing.remove(ongoing.size()-1);
    }
}