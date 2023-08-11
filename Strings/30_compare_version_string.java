//more optimized
public class Solution {
public int compareVersion(String version1, String version2) {
    int temp1 = 0,temp2 = 0;
    int len1 = version1.length(),len2 = version2.length();
    int i = 0,j = 0;
    while(i<len1 || j<len2) {
        temp1 = 0;
        temp2 = 0;
        while(i<len1 && version1.charAt(i) != '.') {
            temp1 = temp1*10 + version1.charAt(i++)-'0';
            
        }
        while(j<len2 && version2.charAt(j) != '.') {
            temp2 = temp2*10 + version2.charAt(j++)-'0';
            
        }
        if(temp1>temp2) return 1;
        else if(temp1<temp2) return -1;
        else {
            i++;
            j++;
            
        }
        
    }
    return 0;
    
}



// optimized approch
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