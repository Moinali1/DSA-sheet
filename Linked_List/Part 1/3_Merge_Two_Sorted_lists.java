class Solution {
    
   class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
   
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode it=head;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                it.next=l1;
                l1=l1.next;
            }
            else if(l1.val>l2.val)
            {
                it.next=l2;
                l2=l2.next;
            }
            it=it.next;
        }
        if(l1==null)it.next=l2;
        else if(l2==null)it.next=l1;
        return head.next;
    }
}

// https://leetcode.com/problems/merge-two-sorted-lists/description/