class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j= s.length-1;
        reverse(s,i,j);
    }
    public void reverse(char s[],int i,int j)
    {
        if(i>=j)return;
        char temp=s[i];
        s[i]=s[j];
        s[j]= temp;
        reverse(s,++i,--j);
    }
}

// class Solution {
//     public void reverseString(char[] s) {
//       int i=0,j=s.length-1;
//       while(i<=j)swap(s,i++,j--);
//     }
//     public void swap(char[] arr,int i,int j)
//     {
//         char temp=arr[i];
//         arr[i]=arr[j];
//         arr[j]=temp;
//     }
// }