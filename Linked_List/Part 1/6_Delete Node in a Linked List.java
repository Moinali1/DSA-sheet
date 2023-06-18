
class Solution {
    public void deleteNode(ListNode node) {
            node.val=node.next.val;
            node.next=node.next.next;
    }
}



// first
class Soluion {
    public void deleteNode(ListNode node) {
        while(node.next.next!=null)
        {
            node.val=node.next.val;
            node=node.next;
        }
        node.val=node.next.val;
        node.next=null;
    }
}