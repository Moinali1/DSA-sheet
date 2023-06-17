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