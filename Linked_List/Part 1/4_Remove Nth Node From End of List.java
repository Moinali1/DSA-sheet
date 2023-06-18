
class Solutio {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)return null;
        ListNode temp= new ListNode(0);
        temp.next=head;
        ListNode slow=temp;
        ListNode fast=temp;
        while(n>0) 
        {   --n;
            fast=fast.next;
        }
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return temp.next;
    }
}

recursion


class Solution {
    int n;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null)return null;
        this.n=n;
        ListNode preHead=new ListNode(0);
        preHead.next=head;
        removeNode(preHead);
        return preHead.next;
    }
    public void removeNode(ListNode head)
    {
        if(head.next==null)
        {--n;return;}
        removeNode(head.next);
        if(n==0) head.next=head.next.next;
        --n;
    }
}

