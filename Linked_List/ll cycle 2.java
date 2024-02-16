/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head,slow=head;
        do{
            if(fast==null ||fast.next==null)return null;
            slow=slow.next;
            fast=fast.next.next;
        }while(fast!=slow);
        while(slow!=head)
        {
            slow=slow.next;
            head=head.next;
        }
        return head;
    }
}