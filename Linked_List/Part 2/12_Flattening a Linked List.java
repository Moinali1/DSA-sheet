class GfG
{
    Node flatten(Node root)
    {
	 return helper(root,root.next);
    }
    Node helper(Node l1,Node l2)
    {
        if(l2==null)return l1;
        Node nxt=l2.next;
        Node res=merge(l1,l2);
        return helper(res,nxt);
    }
    Node merge(Node l1,Node l2)
    {
        Node res=new Node(0);
        Node start=res;
        
        while(l1!=null && l2!=null)
        {
            if(l1.data<=l2.data)
            {
                start.bottom=l1;
                l1=l1.bottom;
            }
            else
            {
                start.bottom=l2;
                l2=l2.bottom;
            }
            start=start.bottom;
        }
        if(l1==null)start.bottom=l2;
        else start.bottom=l1;
        
        return res.bottom;
    }
}

