class Solution {
    public boolean isPalindrome(ListNode head) {
     ListNode fast=head,slow=head;
     while(fast!=null && fast.next!=null)
     {
         fast=fast.next.next;
         slow=slow.next;
     }   
     ListNode pre=null,cur=slow,nxt=slow.next;
     while(cur!=null)
     {
         cur.next=pre;
         pre=cur;cur=nxt;
         if(nxt!=null)nxt=nxt.next;
     }
     while(head!=pre && pre!=null)
     {
         if(head.val!=pre.val)return false;
         head=head.next;pre=pre.next;
     }
     return true;
    }
}