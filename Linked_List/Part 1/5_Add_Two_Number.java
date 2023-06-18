//optimized
class Solutin {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode itr=head;
        int carry=0;
        while(l1!=null ||l2!=null || carry==1)
        {
            int sum=0;
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            ListNode node=new ListNode(sum%10);
            itr.next=node;
            itr=itr.next;
        }
        return head.next;
    }
}

// better optimized
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode itr=head;
        int carry=0;
        while(l1!=null ||l2!=null)
        {
            int a=l1!=null?l1.val:0;
            int b=l2!=null?l2.val:0;
            int sum=(a+b+carry);
            ListNode node=new ListNode(sum%10);
            itr.next=node;
            itr=itr.next;
            carry=sum/10;

            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;  
        }
        if(carry!=0)
        {
            ListNode node=new ListNode(1);
            itr.next=node;
        }
        return head.next;
    }
}



// First Approch
class Solutio {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1=new StringBuilder("");
        StringBuilder s2=new StringBuilder("");

        while(l1!=null)
        {
            s1.append(l1.val);
            l1=l1.next;
        }
        while(l2!=null)
        {
            s2.append(l2.val);
            l2=l2.next;
        }
        String s=addString(s1,s2);
        ListNode head=new ListNode(s.charAt(0)-'0');
        ListNode it=head;
        int i=1;
        while(i<s.length())
        {
          ListNode node=new ListNode(s.charAt(i)-'0');  
          it.next=node;
          it=it.next;
          i++;
        }
        return head;
    }

    public String addString(StringBuilder s1,StringBuilder s2)
    {
        StringBuilder sb=new StringBuilder("");
        int i=0,j=0,carry=0;
        while(i<s1.length() || j<s2.length())
        {
            int a=j<s1.length()?s1.charAt(i)-'0':0;
            int b=j<s2.length()?s2.charAt(j)-'0':0;

            sb.append((a+b+carry)%10);
            carry=(a+b+carry)/10;
            i++;j++;
        }
        if(carry!=0)sb.append(carry);
        return sb.toString();
    }
}