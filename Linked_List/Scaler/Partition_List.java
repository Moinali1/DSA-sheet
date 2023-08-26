
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null)return null;
        ListNode p1=new ListNode(0),p2=new ListNode(0);
        ListNode HeadP1=null,HeadP2=null;
        ListNode cur=head;

        while(cur!=null)
        {
            if(cur.val<x){
                if(HeadP1==null)HeadP1=cur;
                p1.next=cur;
                p1=p1.next;
            }
            else{
                if(HeadP2==null)HeadP2=cur;
                p2.next=cur;
                p2=p2.next;
            }
            cur=cur.next;   
        }
        p2.next=null;//removing cycle

        if(HeadP1!=null)p1.next=HeadP2; // Case [1] x=0;
        else return HeadP2;

        return HeadP1;
    }
}

// https://leetcode.com/problems/partition-list/description/






//gfg into this there are three partitions
class Solution {
    public static Node partition(Node head, int x) {
        if(head==null)return null;
        Node p1=new Node(0);
        Node pMid=new Node(0);
        Node p2=new Node(0);
        Node HeadP1=null,HeadMid=null,HeadP2=null;
        Node cur=head;

        while(cur!=null)
        {
            if(cur.data<x){
                if(HeadP1==null)HeadP1=cur;
                p1.next=cur;
                p1=p1.next;
            }
            else if(cur.data==x)
            {
                if(HeadMid==null)HeadMid=cur;
                pMid.next=cur;
                pMid=pMid.next;
            }
            else{
                if(HeadP2==null)HeadP2=cur;
                p2.next=cur;
                p2=p2.next;
            }
            cur=cur.next;   
        }
        p2.next=null;//removing cycle
        p1.next=null;
        pMid.next=null;
       
        if(HeadP1!=null)
        {
            if(HeadMid!=null){
                p1.next=HeadMid;
                pMid.next=HeadP2;
            }
            else if(HeadMid==null) p1.next=HeadP2;
        }
        else{
            if(HeadMid!=null){
                HeadP1=HeadMid;
                pMid.next=HeadP2;
            }
            else HeadP1=HeadP2;
        }
        
        
        return HeadP1;
    }
}