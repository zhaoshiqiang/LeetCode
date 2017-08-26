package linklist;

/**第25
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     You may not alter the values in the nodes, only nodes itself may be changed.
     Only constant memory is allowed.

     For example,
     Given this linked list: 1->2->3->4->5
     For k = 2, you should return: 2->1->4->3->5
     For k = 3, you should return: 3->2->1->4->5

 * Created by zhaoshiqiang on 2017/2/2.
 */
//链表  快慢指针
public class Reverse_Nodes_in_k_Group {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        int count=0;
        ListNode pre=dummy;
        ListNode cur=head;
        while (cur!=null){
            count++;
            ListNode next = cur.next;
            if (count == k){
                pre=reverse(pre,next);
                count=0;
            }
            cur=next;
        }
        return dummy.next;
    }

    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * pre        next
     * after call pre = reverse(pre, next)
     *
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     */
    private static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur=last.next;
        while (cur!=next){
//            ListNode p = cur.next;
//            cur.next=pre.next;
//            pre.next=cur;
//            cur=p;
            last.next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
            cur=last.next;
        }
//        last.next=next;
        return last;
    }
    static class ListNode {
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
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode p= reverseKGroup(node1, 2);
        while ( p!=null ){
            System.out.print(p.val + " ");
            p=p.next;
        }
    }
}
