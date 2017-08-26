package linklist;

/**第19
 * Given a linked list, remove the nth node from the end of list and return its head.

     For example,
     Given linked list: 1->2->3->4->5, and n = 2.
     After removing the second node from the end, the linked list becomes 1->2->3->5.
     Note:
     Given n will always be valid.
     Try to do this in one pass.
 * Created by zhaoshiqiang on 2017/2/2.
 */
//快慢指针
public class Remove_Nth_Node_From_End_of_List {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null){
            return head;
        }
        ListNode slow=head,fast=head;
        for (int i=0; i<n; i++){
            fast=fast.next;
        }
        if (fast==null){
            head=head.next;
            return head;
        }
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;
//        node4.next=node5;
        ListNode p = removeNthFromEnd(node1,2);

        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
