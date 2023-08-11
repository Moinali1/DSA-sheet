class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
       String[] arr=s.split("\\.");
       StringBuilder sb= new StringBuilder();
       
       for(int i=arr.length-1;i>=0;i--)
       {
           sb.append(arr[i]+".");
       }
       String ans=sb.substring(0,sb.length()-1);
       return ans;
    }
}


// class Solution 
// {
//     //Function to reverse words in a given string.
//     String reverseWords(String s)
//     {
//         char[] arr=s.toCharArray();
//         revarr(arr,0,arr.length-1);// reverse the array
//         int idx=0;
//         for(int i=0;i<arr.length;i++)
//         {
//             if(arr[i]=='.')
//             {
//                 revarr(arr,idx,i-1); //reverse each word except last
//                 idx=i+1;
//             }
//         }
//         revarr(arr,idx,arr.length-1); //reversing the last word
        
//         StringBuilder sb= new StringBuilder();
//         for(char i: arr) sb.append(i);
        
//         return sb.toString();
//         }
//     void revarr(char[] arr,int i,int j)
//     {
//         while(i<=j)
//         {
//             char temp=arr[i];
//             arr[i]=arr[j];
//             arr[j]=temp;
//             i++;j--;
//         }
//     }
// }