class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        // if(head)
        ListNode slow=head,fast=head,itr=head;int len=1;
        while(itr.next!=null)
        {
           itr=itr.next; len++;
        }
        k=k%len;
        if(k==0)return head;
        while(k>0)
        { fast=fast.next; k--; }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        ListNode newHead=slow.next;
        fast.next=head;
        slow.next=null;
        return newHead;

    }
}