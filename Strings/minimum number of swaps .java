
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            list.add(new int[]{nums[i],i});
        }
        
        Collections.sort(list, new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
        return (Integer)(a[0]-b[0]);
        }});
        
        int ans=0,i=0;
        while(i<nums.length)
        {
            if(i!=list.get(i)[1])
            {
                ans++;
                Collections.swap(list,i,list.get(i)[1]);
            }
            else i++;
        }
        return ans;
        
    }
}