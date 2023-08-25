// Optimize middle function more 
class Solution { //Using Merge Sort
    public ListNode sortList(ListNode head) {
    if(head==null || head.next==null)
    {
        return head;
    }
    ListNode mid=midele(head);
    ListNode left=sortList(head);
    ListNode right=sortList(mid);
    return merge(left,right);  
    }
public static ListNode merge(ListNode left,ListNode right)
{
        ListNode ans=new ListNode();
        ListNode res=ans;
        while(left!=null && right!=null)
        {
            if(left.val<=right.val)
            {
                ans.next=left;
                left=left.next;
                ans=ans.next;
            }
            else
            {
                ans.next=right;
                right=right.next;
                ans=ans.next;
            }
        }
        while(left!=null)
        {
                ans.next=left;
                left=left.next;
                ans=ans.next;   
        }
        while(right!=null)
        {
                ans.next=right;
                right=right.next;
                ans=ans.next;
        }
        return res.next;
    }
    
    
    public static ListNode midele(ListNode head)
    {
        ListNode n= head;
        int length=0;
        while(n!=null)
        {
            length++;
            n=n.next;
        }
        int len=length/2;
        ListNode m= head;
        if(length%2==0)
        {
        while(len!=1)
            {
            m=m.next;
            len--;
            }
        }
        else
        {
        while(len!=0)
            {
            m=m.next;
            len--;
            }
        }
        ListNode mnxt=m.next;
        m.next=null;
        return mnxt;
        
    }
}


//TLE

// class Solution {
//     public ListNode sortList(ListNode head) {
//         if(head==null)return null;
//         return sort(head,1,getListLen(head));
//     }

//     public ListNode sort(ListNode head,int st,int end)
//     {
//         if(end-st<=0)return new ListNode(findNode(head,st).val);

//         int mid= (st+end)/2;
//         ListNode left=sort(head,st,mid);
//         ListNode right=sort(head,mid+1,end);

//         return mergeList(left,right,st,mid,end);
//     }

//     public ListNode mergeList(ListNode l1,ListNode l2,int st,int mid,int end)
//     {
//         ListNode head=new ListNode(0);
//         int l1len=mid-st+1,l2len=end-(mid+1)+1;

//         ListNode newHead=new ListNode(0);
//         ListNode newItr=newHead;

//         while(l1len!=0 && l2len!=0)
//         {
//             if(l1.val<l2.val)
//             {
//                 ListNode node= new ListNode(l1.val);
//                 newItr.next=node;
//                 l1=l1.next;
//                 l1len--;
//             }
//             else{
//                 ListNode node= new ListNode(l2.val);
//                 newItr.next=node;
//                 l2=l2.next;
//                 l2len--;
//             }
//             newItr=newItr.next;
//         }
//         while(l1len!=0){
//             ListNode node= new ListNode(l1.val);
//             newItr.next=node;
//             newItr=newItr.next;
//             l1=l1.next;
//             l1len--;
//         }
//         while(l2len!=0)
//         {
//             ListNode node= new ListNode(l2.val);
//             newItr.next=node;
//             newItr=newItr.next;
//             l2=l2.next;
//             l2len--;
//         }
//         return newHead.next;
//     }

//     public ListNode findNode(ListNode head,int idx){
//         while(idx!=1)
//         {
//             head=head.next;
//             idx--;
//         }
//         return head;
//     }

//     public int getListLen(ListNode head)
//     {
//         int len=0;
//         while(head!=null)
//         {
//             head=head.next;
//             len++;
//         }
//         return len;
//     }
// }