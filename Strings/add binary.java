class Solution {
    public String addBinary(String a, String b) {
        int carry=0;
        int i=a.length()-1,j=b.length()-1;
        
        StringBuilder sb= new StringBuilder("");
        while(i>=0 || j>=0)
        {
            int first=i>=0?a.charAt(i)-'0':0;
            int sec=j>=0?b.charAt(j)-'0':0;
            int sum=first+sec+carry;

            if(sum==0)
            {
                sb.append("0");
                carry=0;
            }
            else if(sum==1)
            {
                sb.append("1");
                carry=0;
            }
            else if(sum==2)
            {
                sb.append("0");carry=1;
            }
            else{
                sb.append("1");carry=1;
            }
            i--;j--;
        }
        if(carry==1)sb.append("1");
        return sb.reverse().toString();
    }
}

// more optimized
// public class Solution {
//     public String addBinary(String a, String b) {
//         StringBuilder sb = new StringBuilder();
//         int i = a.length() - 1, j = b.length() -1, carry = 0;
//         while (i >= 0 || j >= 0) {
//             int sum = carry;
//             if (j >= 0) sum += b.charAt(j--) - '0';
//             if (i >= 0) sum += a.charAt(i--) - '0';
//             sb.append(sum % 2);
//             carry = sum / 2;
//         }
//         if (carry != 0) sb.append(carry);
//         return sb.reverse().toString();
//     }
// }