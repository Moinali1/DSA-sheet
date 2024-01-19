class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n1=nums1.length-1;
        int n2 = nums2.length-1;
        Set<Integer> hashSet = new HashSet<Integer>();
        int count=0;
        for(int i=0; i<=n1;i++)
        {
            for(int j=0;j<=n2;j++)
            {
                if(nums1[i]==nums2[j]){
                    hashSet.add(nums1[i]);
                    }
            }
        }
        int[] array = new int[hashSet.size()];
        int j = 0;
          for (int i: hashSet) {
             array[j++] = i;
          }
        return array;
    }
}