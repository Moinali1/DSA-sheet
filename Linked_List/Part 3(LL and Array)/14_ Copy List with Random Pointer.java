class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node itr=head;
        Node itrnext=head.next;
        
        while(itr!=null)
        {
            Node node=new Node(itr.val);
            itr.next=node;
            node.next=itrnext;
            itr=itrnext;
            if(itrnext!=null)itrnext=itrnext.next;
        }

        itr=head;itrnext=head.next.next;
        Node copyHead=head.next;

        while(itr!=null)
        {
            itr.next.random=itr.random!=null?itr.random.next:null;
            itr=itrnext;
            if(itrnext!=null)itrnext=itrnext.next.next;
        }

        itr=head;itrnext=head.next.next;
        
        while(itr!=null)
        {
            itr.next.next=itr.next.next==null?null:itr.next.next.next;
            itr.next=itrnext;
            itr=itrnext;
            if(itrnext!=null)itrnext=itrnext.next.next;
        }
        return copyHead;
    }
}
