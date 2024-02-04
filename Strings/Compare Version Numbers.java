class Solution {
    public int compareVersion(String v1, String v2) {
       int i=0,j=0;
       StringBuilder subv1= new StringBuilder("");
       StringBuilder subv2= new StringBuilder("");
       while(i<v1.length() || j<v2.length())
       {
        subv1=new StringBuilder(""); subv2=new StringBuilder("");
        while(i<v1.length() && v1.charAt(i)!='.')
        {
            subv1.append(v1.charAt(i++)-'0');
        }
        i++;
        while(j<v2.length() && v2.charAt(j)!='.')
        {
         subv2.append(v2.charAt(j++)-'0');   
        }
        j++;
        
        int subv1Int = subv1.length() == 0 ? 0 : Integer.parseInt(subv1.toString());
        int subv2Int = subv2.length() == 0 ? 0 : Integer.parseInt(subv2.toString());

        if(subv1Int<subv2Int)return -1;
        if(subv1Int>subv2Int)return 1;
       }

       return 0;  
    }
}