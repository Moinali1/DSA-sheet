class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)return head;
        return reverse(head);
    }
    public ListNode reverse(ListNode node)
    {
        if(node.next==null) return node;
        ListNode n=reverse(node.next);
        node.next.next=node;
        node.next=null;
        return n;
    }
}

// https://leetcode.com/problems/reverse-linked-list/description/