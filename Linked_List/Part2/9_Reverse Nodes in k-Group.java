// Better Recursive Approch
class Solution {
    class Pair{
        ListNode listhead;
        ListNode nxthead;
        Pair(ListNode listhead,ListNode nxthead)
        {
            this.listhead=listhead;
            this.nxthead=nxthead;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        return helper(head,k);
    }
    public ListNode helper(ListNode head,int k)
    {
        Pair first=getMainHead(head,k-1);
        if(first==null)return head;
        head.next=helper(first.nxthead,k);
        return first.listhead;
    }
    public Pair getMainHead(ListNode head,int k)
    {
        if(head==null)return null;
        if(k==0)return new Pair(head,head.next); 
        Pair p=getMainHead(head.next,--k);
        if(p==null)return null;
        head.next.next=head;
        head.next=null;
        return p;
    }
}