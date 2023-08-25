lass Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)return null;

        ListNode first=head,second=head.next;
        ListNode evenHead=head.next;

        while(second!=null && second.next!=null)
        {
            first.next=first.next.next;
            first=first.next;
            second.next=second.next.next;
            second=second.next;
        } 
        first.next=evenHead;
        return head;

    }
}

// https://leetcode.com/problems/odd-even-linked-list/solutions/