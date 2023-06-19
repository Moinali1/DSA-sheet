//optimized
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA,B=headB;

        while(A!=B && (A!=null || B!=null))
        {
            A=A==null?headB:A.next;
            B=B==null?headA:B.next;
        }
        return A;
    }
}


//better approch
public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        int Asize=1,Bsize=1;
        ListNode itrA=A,itrB=B;
        while(itrA!=null)
        {
            Asize++;itrA=itrA.next;
        }
        while(itrB!=null)
        {
            Bsize++;itrB=itrB.next;
        }
        int diff=Math.abs(Asize-Bsize);
        while(Asize>Bsize)
        {
            A=A.next;Asize--;
        }
        while(Bsize>Asize)
        {
            B=B.next;Bsize--;
        }
        while(A!=B && A!=null && B!=null)
        {
            A=A.next;B=B.next;
        }
        return A;
    }
}